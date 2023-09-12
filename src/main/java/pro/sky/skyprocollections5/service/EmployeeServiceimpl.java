package pro.sky.skyprocollections5.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollections5.model.Employee;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService{
    private final List<Employee> employeeList;

    public EmployeeServiceimpl(List<Employee> employeeList) {
        this.employeeList = employeeList;

    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
           employeeList.remove(employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
        employeeList.remove(employee);
        return employee;
    }return null;


    }@Override
    public Employee find(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
        return employee;

    }return null;
}
}
