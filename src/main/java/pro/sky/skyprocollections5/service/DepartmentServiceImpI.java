package pro.sky.skyprocollections5.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollections5.exception.EmployeeNotFoundException;
import pro.sky.skyprocollections5.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpI implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartment() == departmentId).max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartment() == departmentId).min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Collection<Employee> getEmployeeByDepartment(Integer departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeeByDepartment() {
        return employeeService.findAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
