package pro.sky.skyprocollections5.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollections5.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprocollections5.exception.EmployeeNotFoundException;
import pro.sky.skyprocollections5.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    private final Map<String, Employee> empolyees;

    public EmployeeServiceimpl() {
        this.empolyees = new HashMap<>();

    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (empolyees.containsKey(employee.getFullName()))
            throw new EmployeeAlreadyAddedException();
        {
            empolyees.put(employee.getFullName(), employee);
            return employee;
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (empolyees.containsKey(employee.getFullName())) {
            return empolyees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();

    }



    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (empolyees.containsKey(employee.getFullName())) {
            return empolyees.get(employee.getFullName());
        }throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
            return Collections.unmodifiableCollection(empolyees.values());
        }

    }




