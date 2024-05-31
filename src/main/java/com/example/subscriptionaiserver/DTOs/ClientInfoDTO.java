package com.example.subscriptionaiserver.DTOs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientInfoDTO {
    private List<Map<String, String>> User;
    private String clientName;
    private ArrayList<String> products;
    private ArrayList<Map<String, Integer>> transactions;
    private ArrayList<String> countryCodes;
    private String language;
    private String redirectURI;
    private Map<String, ArrayList<Map<String, ArrayList<String>>>> accountFilters;
    private ArrayList<Map<String, ArrayList<String>>> credit;

    public List<Map<String, String>> getUser() {
        return User;
    }

    public void setUser(List<Map<String, String>> user) {
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

    public ArrayList<Map<String, Integer>> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Map<String, Integer>> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<String> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(ArrayList<String> countryCodes) {
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

    public Map<String, ArrayList<Map<String, ArrayList<String>>>> getAccountFilters() {
        return accountFilters;
    }

    public void setAccountFilters(Map<String, ArrayList<Map<String, ArrayList<String>>>> accountFilters) {
        this.accountFilters = accountFilters;
    }

    public ArrayList<Map<String, ArrayList<String>>> getCredit() {
        return credit;
    }

    public void setCredit(ArrayList<Map<String, ArrayList<String>>> credit) {
        this.credit = credit;
    }
}
