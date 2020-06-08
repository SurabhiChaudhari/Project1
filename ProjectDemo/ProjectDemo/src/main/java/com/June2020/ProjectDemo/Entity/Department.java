package com.June2020.ProjectDemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "Department")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String Name;


    private String Area;

    @ManyToOne
      @JoinColumn(name="employee_id", nullable = false)
    @JsonIgnore
       private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
