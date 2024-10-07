package com.example.demo.model;

public class Usermodel {
    private String name;
    private String department;
    private String email;
    private Long phone;
    private Long salary;

    public Usermodel(String name, String department, String email, Long phone, Long salary) {
        this.name=name;
        this.department=department;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
