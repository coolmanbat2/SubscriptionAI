package com.example.subscriptionaiserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Storage {

    @Id
    @GeneratedValue
    private int storageId;
    private String accessToken;
    private String username;
    private String encrPass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncrPass() {
        return encrPass;
    }

    public void setEncrPass(String encrPass) {
        this.encrPass = encrPass;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getStorageId() {
        return storageId;
    }
}
