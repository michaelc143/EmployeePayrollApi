package com.example.Payroll.Director;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabaseDirectors {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseDirectors.class);

    @Bean
    CommandLineRunner initDatabaseD(DirectorRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Director("Michael Corbishley", "Sales", "Apple")));
            log.info("Preloading " + repository.save(new Director("Zachary Corbishley", "Cloud", "Apple")));
            log.info("Preloading " + repository.save(new Director("Alex Corbishley", "Customer Success", "Apple")));
        };
    }
}
