package com.June2020.ProjectDemo.Repository;

import com.June2020.ProjectDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByEmailAddress(String emailAddress);
}