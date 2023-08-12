package com.example.Payroll.Director;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DirectorController {
    
    private final DirectorRepository repository;
    DirectorController(DirectorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/directors")
    List<Director> all() {
        return repository.findAll();
    }
}
