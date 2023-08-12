package com.example.Payroll.Director;

class DirectorNotFoundException extends RuntimeException {

  DirectorNotFoundException(Long id) {
    super("Could not find director " + id);
  }
}