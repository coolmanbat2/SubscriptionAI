package com.example.subscriptionaiserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepo extends JpaRepository<Long, String> {
    public List<String> findByAccessToken();
}
