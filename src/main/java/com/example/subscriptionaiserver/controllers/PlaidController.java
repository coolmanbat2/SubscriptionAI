package com.example.subscriptionaiserver.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class PlaidController {
    @GetMapping("/get-link-token")
    public ResponseEntity<String> getLinkToken() {

    }

    @GetMapping("/get-access-token")
    public ResponseEntity<String> getAccessToken() {

    }


}
