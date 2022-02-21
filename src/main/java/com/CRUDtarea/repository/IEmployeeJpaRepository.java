package com.CRUDtarea.repository;

import java.util.List;


import com.CRUDtarea.model.Employee;
import com.CRUDtarea.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee JPA Interface
 * @version 1.0
 */
@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    // select fields from employee where employeeid='[param]'
    Employee findByEmployeeid(String employeeid);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByRole(Role role);

}
