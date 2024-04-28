package com.example.subscriptionaiserver.controllers;


import com.plaid.client.ApiClient;
import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

@RestController("/api")
public class PlaidController {
    private PlaidApi client;
    private String accessToken;
    private ResponseEntity<String> result;
    String clientID = System.getenv("CLIENT_ID");
    String secretKey = System.getenv("SECRET");
    @PostMapping("/exchange-token")
    public ResponseEntity<String> exchangeToken(@RequestBody String public_token) {
        HashMap<String, String> apiKeys = new HashMap<String, String>();
        apiKeys.put("clientID", clientID);
        apiKeys.put("secret", secretKey);

        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        client = apiClient.createService(PlaidApi.class);

        // This is where we use the public token and convert it to an access token for the user.
        ItemPublicTokenExchangeRequest exchangeRequest = new ItemPublicTokenExchangeRequest().publicToken(public_token);
        client.itemPublicTokenExchange(exchangeRequest)
                .enqueue(new Callback<ItemPublicTokenExchangeResponse>() {
                    @Override
                    public void onResponse(Call<ItemPublicTokenExchangeResponse> call, Response<ItemPublicTokenExchangeResponse> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null; // ngl, i don't know why this was here. Intellij Suggested it just in case of null response. :/
                            accessToken = response.body().getAccessToken();
                            // Save access token to database.

                            result = new ResponseEntity<String>(accessToken, HttpStatus.OK); // TODO: Please find an alternative to sending this directly to the client as it could be intercepted.
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemPublicTokenExchangeResponse> call, Throwable throwable) {
                        result =  new ResponseEntity<String>("Unable to complete request. Please contact Customer Support regarding this issue.", HttpStatus.INTERNAL_SERVER_ERROR);
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
