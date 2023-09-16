package com.example.vault;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HitsController {
    @Autowired
    private HitRepository hitRepository;

    @PostMapping("/")
    public Hit addHit(@RequestBody Hit hit) {
        return hitRepository.save(hit);
    }

    @GetMapping("/{year}")
    public List<Hit> getAllByYear(@PathVariable int year) {
        return hitRepository.findByYear(year);
    }

    @GetMapping("/{year}/count")
    public int getHitCountByYear(@PathVariable int year) {
        return hitRepository.findByYear(year).size();
    }
}
