package org.example.parkinglot.models;

public class Operator {
    private Long id;
    private String employeeId;
    private String name;

    public Operator(Long id, String employeeId, String name) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
}
