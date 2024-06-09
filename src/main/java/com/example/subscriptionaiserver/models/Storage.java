package com.example.subscriptionaiserver.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "accesskeys")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storageId;
    private String accessToken;
    @NotNull
    private String username;
    @NotNull
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
