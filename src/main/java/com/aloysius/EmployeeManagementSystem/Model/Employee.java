package com.aloysius.EmployeeManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private String gradeLevel;
    @Enumerated(EnumType.STRING)
    private Contract_type contractType;

    @Enumerated(EnumType.STRING)
    private Department department;


}
