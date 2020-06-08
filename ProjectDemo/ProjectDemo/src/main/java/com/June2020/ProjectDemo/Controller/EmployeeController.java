package com.June2020.ProjectDemo.Controller;

import com.June2020.ProjectDemo.Entity.Employee;
import com.June2020.ProjectDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    List<Employee> getEmployee() {
        List<Employee> employee = employeeRepository.findAll();
        return employee;
    }

    @PostMapping("/employee")
    Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    Employee updateEmployee(@PathVariable(name = "id") Long id, @Valid @RequestBody Employee employee) throws Exception {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if (oldEmployee.isPresent()) {
            //product consists of new values -> oldProduct
            oldEmployee.get().setFirstName(employee.getFirstName());
            oldEmployee.get().setLastName(employee.getLastName());
            oldEmployee.get().setEmailAddress(employee.getEmailAddress());
            oldEmployee.get().setSalary(employee.getSalary());
            return employeeRepository.save(oldEmployee.get());
        } else {
            throw new Exception("Invalid id");
        }
        //
        //
    }


    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return "Deleted!";
        } else {
            throw new Exception("Invalid id");
        }
    }
}

