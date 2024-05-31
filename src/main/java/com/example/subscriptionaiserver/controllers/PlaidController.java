package com.example.subscriptionaiserver.controllers;


import com.example.subscriptionaiserver.DTOs.ClientInfoDTO;
import com.plaid.client.ApiClient;
import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.plaid.client.model.LinkTokenCreateRequestUser;
import com.plaid.client.request.PlaidApi;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

@RestController("/")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaidController {
    private String accessToken;
    private ResponseEntity<String> result;
    String clientID = System.getenv("CLIENT_ID");
    String secretKey = System.getenv("SECRET");

    private PlaidApi initializeKeys() {
        HashMap<String,String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", clientID);
        apiKeys.put("secret", secretKey);
        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Sandbox);
        return apiClient.createService(PlaidApi.class);
    }

    @PostMapping("/link-token")
    public ResponseEntity<String> createLinkToken(@RequestBody ClientInfoDTO infoDTO) {
       PlaidApi client = initializeKeys();
        System.out.println(infoDTO.getLanguage());
       // Create link token request based on the information given from our DTO.

       return new ResponseEntity<>("message sample", HttpStatus.OK);
    }

    @PostMapping("/exchange-token")
    public ResponseEntity<String> exchangeToken(@RequestBody String public_token) {
        PlaidApi client = initializeKeys();
        System.out.println(public_token);


        // This is where we use the public token and convert it to an access token for the user.
        ItemPublicTokenExchangeRequest exchangeRequest = new ItemPublicTokenExchangeRequest().publicToken(public_token);
        client.itemPublicTokenExchange(exchangeRequest)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(@NotNull Call<ItemPublicTokenExchangeResponse> call, @NotNull Response<ItemPublicTokenExchangeResponse> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null; // ngl, i don't know why this was here. Intellij Suggested it just in case of null response. :/
                            accessToken = response.body().getAccessToken();
                            // Save access token to database.

                            result = new ResponseEntity<>(accessToken, HttpStatus.OK); // TODO: Please find an alternative to sending this directly to the client as it could be intercepted.
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemPublicTokenExchangeResponse> call, Throwable throwable) {
                        result = new ResponseEntity<>("Unable to complete request. Please contact Customer Support regarding this issue.", HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                });
        return result;
    }

    // TODO: implement this part please.
    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return null;
    }

}
