package pro.sky.skyprocollections5.service;

import pro.sky.skyprocollections5.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Collection<Employee> getEmployeeByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getEmployeeByDepartment();
}
