package pro.sky.skyprocollections5.service;

import pro.sky.skyprocollections5.model.Employee;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}
