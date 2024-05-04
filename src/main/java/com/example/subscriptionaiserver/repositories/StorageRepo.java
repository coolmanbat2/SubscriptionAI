package com.example.subscriptionaiserver.repositories;

import com.example.subscriptionaiserver.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {
    public List<String> findByAccessToken(String username);
}
