package com.aloysius.EmployeeManagementSystem.Controller;

import com.aloysius.EmployeeManagementSystem.DTO.EmployeeDTO;
import com.aloysius.EmployeeManagementSystem.DTO.EmployeeMapper;
import com.aloysius.EmployeeManagementSystem.Model.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee){
         employeeMapper.addEmployee(employee);
    }
    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeMapper.getAllEmployee();
    }
    @GetMapping(path = "{id}")
    public EmployeeDTO findEmployeeById(@PathVariable ("id") Integer id) throws Exception {
        return employeeMapper.findEmployeeById(id);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleExceptions(Exception exception){
        return  ResponseEntity.badRequest().body(exception.getMessage());

    }
}
