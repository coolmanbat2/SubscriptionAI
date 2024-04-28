package com.example.subscriptionaiserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Storage {

    @Id
    @GeneratedValue
    private Long storageId;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getStorageId() {
        return storageId;
    }
}
