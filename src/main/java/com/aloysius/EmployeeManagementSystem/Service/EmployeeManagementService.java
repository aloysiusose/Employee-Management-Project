package com.aloysius.EmployeeManagementSystem.Service;

import com.aloysius.EmployeeManagementSystem.Model.Employee;
import com.aloysius.EmployeeManagementSystem.Repository.EmployeeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> listOfAllEmployee(){
        return employeeRepository.findAll();
    }

    //find employee by id
    public Employee findEmployeeById(Integer id) throws Exception {
        return employeeRepository.findById(id).orElseThrow(()-> new Exception("Employee with id: " + id + " not found"));
    }
    /* couple more method to implement
    find employee by contract type
    find employee by department type
    find the oldest serving employee
    birthday celebration of employee

     */
}
