package com.aloysius.EmployeeManagementSystem.DTO;

import com.aloysius.EmployeeManagementSystem.Model.Employee;
import com.aloysius.EmployeeManagementSystem.Service.EmployeeManagementService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Getter
@Setter
@NoArgsConstructor
public class EmployeeMapper {

    @Autowired
    private EmployeeManagementService employeeManagementService;

    private static EmployeeDTO employeeByIdMapper(Employee employeeById) {
        Employee employee = new Employee();
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employeeById.getId());
        employeeDTO.setFirstName(employeeById.getFirstName());
        employeeDTO.setLastName(employeeById.getLastName());
        employeeDTO.setStartDate(employeeById.getStartDate());
        employeeDTO.setDepartment(employeeById.getDepartment());

        return employeeDTO;
    }

    public Employee addEmployee(Employee employee) {

        return employeeManagementService.addEmployee(employee);
    }
    public List<EmployeeDTO> getAllEmployee() {

        return employeeManagementService.listOfAllEmployee().stream()
                .map(EmployeeMapper::employeeByIdMapper)
                .collect(Collectors.toList());
    }
    public EmployeeDTO findEmployeeById(Integer id) throws Exception {
        Employee employeeById = employeeManagementService.findEmployeeById(id);

        EmployeeDTO employeeDTO = null;
        if (!employeeById.equals(null)) {
            employeeDTO = employeeByIdMapper(employeeById);
        }
        return employeeDTO;

    }
}
