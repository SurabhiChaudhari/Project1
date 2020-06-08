package com.June2020.ProjectDemo.Controller;

import com.June2020.ProjectDemo.Entity.Department;
import com.June2020.ProjectDemo.Entity.Employee;
import com.June2020.ProjectDemo.Repository.DepartmentRepository;
import com.June2020.ProjectDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/employee/{employeeId}/department")
    List<Department> getDepartmentByDepartment(@PathVariable(name = "employeeId") Long employeeId) throws Exception{
    Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isPresent()){
         return departmentRepository.findByEmployee(employee.get());
   }else{
       throw new Exception("Invalid id");
     }
  }
 //get
    @GetMapping("/department")
    List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }


    //post
    @PostMapping("/employee/{employeeId}/department")
    Department addDepartment(@PathVariable(name="employeeId") Long employeeId, @Valid @RequestBody Department department) throws Exception{
      Optional<Employee> employee = employeeRepository.findById(employeeId);
    if(employee.isPresent()){
         department.setEmployee(employee.get());
         return departmentRepository.save(department);
    }else{
           throw new Exception("Invalid id");
    }

}

//Put
@PutMapping("/employee/{employeeId}/department/{id}")
Department updateDepartment(@PathVariable(name="employeeId") Long employeeId, @PathVariable(name="id") Long id,@Valid @RequestBody Department department) throws Exception{
    Optional<Employee> employee = employeeRepository.findById(employeeId);
    if(employee.isPresent()){
        Optional<Department> oldDepartment = departmentRepository.findById(id);
        if(oldDepartment.isPresent()){
            oldDepartment.get().setName(department.getName());
            oldDepartment.get().setArea(department.getArea());
            return departmentRepository.save(oldDepartment.get());
        }else{
            throw new Exception("Invalid order id");
        }
    }else{
        throw new Exception("Invalid product id");
    }
}

@PatchMapping("/employee/{employeeId}/department/{id}")
Department PartialupdateDepartment(@PathVariable(name="employeeId") Long employeeId, @PathVariable(name="id") Long id,@Valid @RequestBody Department department) throws Exception{
    Optional<Employee> employee = employeeRepository.findById(employeeId);
    if(employee.isPresent()){
        Optional<Department> oldDepartment = departmentRepository.findById(id);
        if(oldDepartment.isPresent()){
            oldDepartment.get().setName(department.getName());
            oldDepartment.get();
            return departmentRepository.save(oldDepartment.get());
        }else{
            throw new Exception("Invalid order id");
        }
    }else{
        throw new Exception("Invalid product id");
    }
}





//Delete
    @DeleteMapping("/employee/{employeeId}/department/{id}")
  String deleteDepartment(@PathVariable(name="employeeId") Long employeeId, @PathVariable(name="id") Long id,@Valid @RequestBody Department department) throws Exception{
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            Optional<Department> oldDepartment = departmentRepository.findById(id);
            if(oldDepartment.isPresent()) {
                departmentRepository.deleteById(id);
                return "Department Deleted!";
            } else {
                return "Can't delete Order Invalid Order id";
            }
        }else{
            return "Can't delete order because Invalid Product Id";
        }
    }

}




