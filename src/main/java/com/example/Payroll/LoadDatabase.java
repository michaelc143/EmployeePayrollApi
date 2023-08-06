package com.example.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "Burglar", 0)));
      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "Thief", 100000)));
      log.info("Preloading " + repository.save(new Employee("Michael Corbishley", "Engineer", 200000)));
      log.info("Preloading " + repository.save(new Employee("Zachary Corbishley", "Cloud", 200000)));
      log.info("Preloading " + repository.save(new Employee("Alex Corbishley", "Sales", 200000)));
    };
  }
}