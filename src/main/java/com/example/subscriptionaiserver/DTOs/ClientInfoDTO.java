package com.example.subscriptionaiserver.DTOs;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientInfoDTO {
    private HashMap<String, String> User;
    private String clientName;
    private ArrayList<String> products;
    private HashMap<String, Integer> transactions;
    private String countryCodes;
    private String language;
    private String redirectURI;
    private HashMap<String, HashMap<String, ArrayList<String>>> accountFilters;
    private HashMap<String, String> credit;

    public HashMap<String, String> getUser() {
        return User;
    }

    public void setUser(HashMap<String, String> user) {
        User = user;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public HashMap<String, Integer> getTransactions() {
        return transactions;
    }

    public void setTransactions(HashMap<String, Integer> transactions) {
        this.transactions = transactions;
    }

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> getAccountFilters() {
        return accountFilters;
    }

    public void setAccountFilters(HashMap<String, HashMap<String, ArrayList<String>>> accountFilters) {
        this.accountFilters = accountFilters;
    }

    public HashMap<String, String> getCredit() {
        return credit;
    }

    public void setCredit(HashMap<String, String> credit) {
        this.credit = credit;
    }
}
