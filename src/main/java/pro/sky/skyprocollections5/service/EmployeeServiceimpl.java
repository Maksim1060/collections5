package pro.sky.skyprocollections5.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollections5.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprocollections5.exception.EmployeeNotFoundException;
import pro.sky.skyprocollections5.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService{
    private final List<Employee> employeeList;

    public EmployeeServiceimpl() {
        this.employeeList = new ArrayList<>();

    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }employeeList.remove(employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
        employeeList.remove(employee);
        return employee;
    }throw new EmployeeNotFoundException();


    }@Override
    public Employee find(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
        return employee;

    }throw new EmployeeNotFoundException();
}

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
