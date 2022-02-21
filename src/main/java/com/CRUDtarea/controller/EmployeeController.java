package com.CRUDtarea.controller;

import com.CRUDtarea.model.Employee;
import com.CRUDtarea.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeJpaRepository iEmployeeJpaRepository;

    /**
     * Devuelve todos los empleados que hay en la tabla
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            iEmployeeJpaRepository.findAll().forEach(employees::add);
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Crea un empleado con los datos ingresados
     * @param employee
     * @return
     */
    @PostMapping("/post")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = iEmployeeJpaRepository
                    .save(new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmployeeid(),
                            employee.getRole()));
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Busca un empleado en base a su ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        Optional<Employee> employeeData = iEmployeeJpaRepository.findById(id);

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Borra un empleado en base a su ID
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        try {
            iEmployeeJpaRepository.deleteById(id);
            return new ResponseEntity<>("Employees DELETED!! ", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Actualiza un empleado con los datos ingresados
     * @param id
     * @param employee
     * @return
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = iEmployeeJpaRepository.findById(id);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setEmployeeid(employee.getEmployeeid());
            _employee.setFirstName(employee.getFirstName());
            _employee.setLastName(employee.getLastName());
            _employee.setRole(employee.getRole());
            return new ResponseEntity<>(iEmployeeJpaRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}