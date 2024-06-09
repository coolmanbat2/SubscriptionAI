package com.example.subscriptionaiserver.controllers;


import com.example.subscriptionaiserver.DTOs.ClientInfoDTO;
import com.example.subscriptionaiserver.exceptions.LinkTokenCreationFailedException;
import com.example.subscriptionaiserver.models.Storage;
import com.example.subscriptionaiserver.repositories.StorageRepo;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController("/")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaidController {
    @Value("${plaid.client.id}")
    String clientID;
    @Value("${plaid.client.secret}")
    String secretKey;
    final StorageRepo<Storage> storageRepo;

    public PlaidController(StorageRepo<Storage> storageRepo) {
        this.storageRepo = storageRepo;
    }


    private PlaidApi initializeKeys() {
        HashMap<String,String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", clientID);
        apiKeys.put("secret", secretKey);
        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Sandbox);
        return apiClient.createService(PlaidApi.class);
    }

    @PostMapping("/link-token")
    public ResponseEntity<LinkTokenCreateResponse> createLinkToken(@RequestBody ClientInfoDTO infoDTO) throws IOException, LinkTokenCreationFailedException {
       PlaidApi client = initializeKeys();

       Map<String, String> userValues = infoDTO.getUser().get(0);

       LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
               .clientUserId(userValues.get("clientUserId"))
               .phoneNumber(userValues.get("phoneNumber"))
               .legalName(userValues.get("legalName"));

        LinkTokenCreateRequest requestToken = new LinkTokenCreateRequest()
                .user(user)
                .clientName(infoDTO.getClientName())
                .products(infoDTO.getProducts())
                .countryCodes(infoDTO.getCountryCodes())
                .language(infoDTO.getLanguage())
                .redirectUri(infoDTO.getRedirectURI())
                .clientId(clientID)
                .secret(secretKey);


        LinkTokenCreateResponse response = client.linkTokenCreate(requestToken).execute().body();

        if (response == null) {
            throw new LinkTokenCreationFailedException("Link Token Creation Failed!");
        }



        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/exchange-token")
    public ResponseEntity<String> exchangeToken(@RequestBody Map<String, String> data) throws IOException {
        PlaidApi client = initializeKeys();
        String public_token = data.get("public_token");
        System.out.println(public_token);
        // This is where we use the public token and convert it to an access token for the user.
        ItemPublicTokenExchangeRequest exchangeRequest = new ItemPublicTokenExchangeRequest().publicToken(public_token);
        Response<ItemPublicTokenExchangeResponse> response = client.itemPublicTokenExchange(exchangeRequest).execute();
        if (response.body() != null && response.isSuccessful()) {
        // Save the access token to the server.
            Storage storage = new Storage();
            storage.setAccessToken(response.body().getAccessToken());
//            TODO: THIS IS A TEST USER, PLEASE DELETE THIS ONCE OAUTH2 IS SETUP.
            storage.setUsername("ryekg");
            storage.setEncrPass("dskfiwqjrgohb3t240gh08eqrjgdahf24");
//           TODO: END OF TEST USER
            storageRepo.saveAndFlush(storage);
            return new ResponseEntity<>(response.message(), HttpStatus.OK);
        } else {
            throw new IOException("Failed: " + response);
        }
    }

    // TODO: implement this part please.
    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return null;
    }

}
