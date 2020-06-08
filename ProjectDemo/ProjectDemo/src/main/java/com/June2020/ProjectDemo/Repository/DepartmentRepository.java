package com.June2020.ProjectDemo.Repository;

import com.June2020.ProjectDemo.Entity.Department;
import com.June2020.ProjectDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public List<Department> findByEmployee(Employee employee);


}
