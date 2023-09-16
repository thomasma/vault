package com.example.vault;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HitRepository extends MongoRepository<Hit, String> {

    Hit findHitByTrackId(String trackIdname);

    List<Hit> findByYear(int year);

    public long count();

}