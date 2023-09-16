package com.example.vault;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("hits")
@Data
public class Hit {

    @Id
    private String id;

    private String playlistUrl;
    private Integer year;
    private String trackId;
    private String trackName;
    private Integer trackPopularity;
    private String album;
    private String artistId;
    private String artistName;
    private List<String> artistGenres = List.of();
    private Integer artistPopularity = 0;
    private Float danceability = 0f;
    private Float energy = 0f;
    private Integer key = 0;
    private Float loudness = 0f;
    private Integer mode = 0;
    private Float speechiness = 0f;
    private Float sacousticness = 0f;
    private Float sinstrumentalness = 0f;
    private Float sliveness = 0f;
    private Float svalence = 0f;
    private Float stempo = 0f;
    private Integer sdurationMs = 0;
    private Integer timeSignature = 0;
}
