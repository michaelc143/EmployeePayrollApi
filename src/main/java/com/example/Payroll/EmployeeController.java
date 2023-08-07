package com.example.Payroll;
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
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }

  // Get all roles
  @GetMapping("/employees/roles")
  List<String> allRoles() {
    List<Employee> employees = repository.findAll();
    List<String> roles = new ArrayList<String>();
    for (Employee employee : employees) { 
      roles.add(employee.getRole());
    }
    return roles;
  }

  // Get all salaries
  @GetMapping("/employees/salaries")
  List<Integer> allSalaries() {
    List<Employee> employees = repository.findAll();
    List<Integer> salaries = new ArrayList<Integer>();
    for (Employee employee : employees) { 
      salaries.add(employee.getSalary());
    }
    return salaries;
  }

  // Get all unique companyIds
  @GetMapping("/employees/companies")
  List<String> allCompanies() {
    List<Employee> employees = repository.findAll();
    List<String> companies = new ArrayList<String>();
    for (Employee employee : employees) { 
      if (!companies.contains(employee.getCompanyId()))
        companies.add(employee.getCompanyId());
    }
    return companies;
  }

  // end::get-aggregate-root[]
  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}