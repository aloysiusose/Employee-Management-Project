package com.aloysius.EmployeeManagementSystem.DTO;

import com.aloysius.EmployeeManagementSystem.Model.Employee;
import com.aloysius.EmployeeManagementSystem.Service.EmployeeManagementService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeMapper {
    Employee employee = new Employee();
    private EmployeeDTO employeeDTO = new EmployeeDTO();
    @Autowired
    private EmployeeManagementService employeeManagementService;

    public Employee addEmployee(Employee employee) {
        return employeeManagementService.addEmployee(employee);
    }
    public List<EmployeeDTO> getAllEmployee() {

        return employeeManagementService.listOfAllEmployee().stream().
                map(employee -> new EmployeeDTO(employee.getId(), employee.getFirstName(),
                        employee.getLastName(), employee.getStartDate(),
                        employee.getDepartment()
                )).collect(Collectors.toList());
    }
    private static void employeeByIdMapper(Employee employeeById, EmployeeDTO employeeDTO) {
        employeeDTO.setId(employeeById.getId());
        employeeDTO.setFirstName(employeeById.getFirstName());
        employeeDTO.setLastName(employeeById.getLastName());
        employeeDTO.setStartDate(employeeById.getStartDate());
        employeeDTO.setDepartment(employeeById.getDepartment());
    }
    public EmployeeDTO findEmployeeById(Integer id) throws Exception {
        Employee employeeById = employeeManagementService.findEmployeeById(id);

        if (!employeeById.equals(null)) {
            employeeByIdMapper(employeeById, employeeDTO);
        }
        return employeeDTO;

    }
}
