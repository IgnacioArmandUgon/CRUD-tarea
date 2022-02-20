package com.CRUDtarea.repository;

import com.CRUDtarea.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> { //Entidad e identificador

    Employee findByEmployeeid(String employeeid);
}
