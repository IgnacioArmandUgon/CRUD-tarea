package com.CRUDtarea.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an employee entity
 * @version 1.0
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false, unique = true)
    private String employeeid;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_role")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project", 
             joinColumns = { @JoinColumn(name = "employee_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "project_id") })
    private List<Project> projects = new ArrayList<Project>();

    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
    }

    public Employee(String firstName, String lastName, String employeeid, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(employeeid, employee.employeeid) && Objects.equals(role, employee.role) && Objects.equals(projects, employee.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, employeeid, role, projects);
    }

    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", firstName=" + firstName + ", id=" + id + ", lastName="
                + lastName + "]";
    }

}
