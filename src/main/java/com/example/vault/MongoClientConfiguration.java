package com.example.vault;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.MongoClientSettings.Builder;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoClientConfiguration extends AbstractMongoClientConfiguration {
    @Autowired
    private VaultConfiguration vaultConfiguration;

    @Override
    public String getDatabaseName() {
        return "spotifyhitsdb";
    }

    @Override
    protected void configureClientSettings(Builder builder) {
        builder
                .credential(MongoCredential.createCredential(vaultConfiguration.getUsername(), "admin",
                        vaultConfiguration.getPassword().toCharArray()))
                .applyToClusterSettings(settings -> {
                    settings.hosts(List.of(new ServerAddress("127.0.0.1", 27017)));
                });
    }
}