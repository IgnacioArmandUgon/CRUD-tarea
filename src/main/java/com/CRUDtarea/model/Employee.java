package com.CRUDtarea.model;

import javax.persistence.*;
import java.util.Objects;

@Entity //Esta tabla representará una entidad, una tabla en la base de datos
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //El motor de base de datos autogenera el valor
    private Long id;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false, unique = true)
    private String employeeid;

    public Employee(){
    }

    public Employee(String firstName, String lastName, String employeeid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeId='" + employeeid + '\'' +
                '}';
    }
}
