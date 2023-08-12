package com.example.Payroll.Director;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Director {
    
    private @Id @GeneratedValue Long id;
    private String name;
    private String department;
    private String companyId;

    Director() {}
    Director(String name, String department, String companyID) {
        this.name = name;
        this.department = department;
        this.companyId = companyID;
    }

    public Long getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDepartment() {
    return this.department;
    }
    
    public String getCompanyId() {
    return this.companyId;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        return true;
        if (!(o instanceof Director))
        return false;
        Director director = (Director) o;
        return Objects.equals(this.id, director.id) && Objects.equals(this.name, director.name)
            && Objects.equals(this.department, director.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.department);
    }

    @Override
    public String toString() {
        return "Director{" + "id=" + this.id + ", name='" + this.name + '\'' + ", department='" + this.department + '\'' + ", companyId='" + this.companyId + '\'' + '}';
    }
}
