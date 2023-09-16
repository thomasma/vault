package com.example.vault;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(VaultConfiguration.class)
public class VaultApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(VaultApplication.class);

	@Autowired
	private VaultConfiguration vaultConfiguration;

	@Autowired
	private HitRepository hitRepository;

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// find all
		List<Hit> hits = hitRepository.findAll();
		logger.info("number of hits returned " + hits.size());
		if (hits.size() > 0)
			logger.info(hits.get(0).toString());

		// find by year
		hits = hitRepository.findByYear(2015);
		logger.info("number of hits returned for year 2015 " + hits.size());
		if (hits.size() > 0)
			logger.info(hits.get(0).toString());

		// just for testing
		logger.info("----------------------");
		logger.info("mongo.username is {}", vaultConfiguration.getUsername());
		// logger.info(" mongo.password is {}", vaultConfiguration.getPassword());
		logger.info("----------------------");
	}

}
