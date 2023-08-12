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

    //Get all director objs
    @GetMapping("/directors")
    List<Director> all() {
        return repository.findAll();
    }

    //Get all departments of all directors
    @GetMapping("/directors/departments")
    List<String> allRoles() {
        List<Director> directors = repository.findAll();
        List<String> departments = new ArrayList<String>();
        for (Director director : directors) { 
            departments.add(director.getDepartment());
        }
        return departments;
    }

    // Get all unique companyIds
    @GetMapping("/directors/companies")
    List<String> allCompanies() {
        List<Director> directors = repository.findAll();
        List<String> companies = new ArrayList<String>();
        for (Director director : directors) { 
        if (!directors.contains(director.getCompanyId()))
            companies.add(director.getCompanyId());
        }
        return companies;
    }

    //Create new employee
    @PostMapping("/directors")
    Director newDirector(@RequestBody Director newDirector) {
        return repository.save(newDirector);
    }

    // Get employee by id
    @GetMapping("/directors/{id}")
    Director one(@PathVariable Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new DirectorNotFoundException(id));
    }

    @DeleteMapping("/directors/{id}")
    void deleteDirector(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
