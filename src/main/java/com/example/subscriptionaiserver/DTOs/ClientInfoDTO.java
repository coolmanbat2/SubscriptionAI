package com.example.subscriptionaiserver.DTOs;

import com.plaid.client.model.CountryCode;
import com.plaid.client.model.LinkTokenAccountFilters;
import com.plaid.client.model.Products;

import java.util.List;
import java.util.Map;

public class ClientInfoDTO {
    private List<Map<String, String>> User;
    private String clientName;
    private List<Products> products;
    private List<Map<String, Integer>> transactions;
    private List<CountryCode> countryCodes;
    private String language;
    private String redirectURI;
    private LinkTokenAccountFilters accountFilters;
    private List<Map<String, List<String>>> credit;

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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Map<String, Integer>> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Map<String, Integer>> transactions) {
        this.transactions = transactions;
    }

    public List<CountryCode> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(List<CountryCode> countryCodes) {
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

    public LinkTokenAccountFilters getAccountFilters() {
        return accountFilters;
    }

    public void setAccountFilters(LinkTokenAccountFilters accountFilters) {
        this.accountFilters = accountFilters;
    }

    public List<Map<String, List<String>>> getCredit() {
        return credit;
    }

    public void setCredit(List<Map<String, List<String>>> credit) {
        this.credit = credit;
    }
}
