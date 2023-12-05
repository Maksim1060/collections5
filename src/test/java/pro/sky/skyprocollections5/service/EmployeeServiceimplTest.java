package pro.sky.skyprocollections5.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.skyprocollections5.exception.EmployeeStorageIsFullException;
import pro.sky.skyprocollections5.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.skyprocollections5.service.EmployeeGenerator.*;

class EmployeeServiceimplTest {
    private final EmployeeServiceimpl employeeServiceimpl=new EmployeeServiceimpl();

    @Test
    void add() {
        String firstName = FIRST_NAME;
        String lastName=LAST_NAME;
        int salary = SALARY;
        int department=FIRST_DEPARTMENT_ID;
        Employee expected = getEmployee();
        Employee actual = employeeServiceimpl.add(firstName, lastName,salary,department);
        assertEquals(expected,actual);


    }

    @Test
    void remove() {
        String firstName = "Ivan";
        String lastName="Ivanov";
        int salary = 45000;
        int department=1;
        Employee expected = new Employee(firstName, lastName,salary,department);
        employeeServiceimpl.add(firstName, lastName,salary,department);
        Employee actual = employeeServiceimpl.remove(firstName, lastName);
        assertEquals(actual,expected);

    }

    @Test
    void find() {
        String firstName = "Ivan";
        String lastName="Ivanov";
        int salary = 45000;
        int department=1;
        Employee expected = new Employee(firstName, lastName);
        employeeServiceimpl.add(firstName, lastName, salary, department);
        Employee actual = employeeServiceimpl.find(firstName, lastName);
        assertEquals(expected,actual);
    }

    @Test
    void findAll() {
        Employee e1= employeeServiceimpl.add("Invan", "Ivanov", 34000, 3);
        Employee e2= employeeServiceimpl.add("Dima", "Sidorov", 46000, 2);
        Collection <Employee> actual=employeeServiceimpl.findAll();
        Collection<Employee> expexted = List.of(e1, e2);
        org.assertj.core.api.Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expexted);
    }
    @Test
    void add_withEmployeeStorageIsFullException(){
        String firstName =FIRST_NAME;
        String lastName=LAST_NAME;
        int salary = SALARY;
        int department=FIRST_DEPARTMENT_ID;
        String firstName2 = FIRST_NAME_2;
        String lastName2=LAST_NAME_2;
        int salary2=SALARY_2;
        String firstName3=FIRST_NAME_3;
        String lastName3=LAST_NAME_2;
        int salary3=SALARY_3;
        String expectedMessage = "400 Массив сотрудников переполнен";
        employeeServiceimpl.add(firstName2, lastName2, salary2, department);
        employeeServiceimpl.add(firstName3, lastName3, salary3, department);
        Exception exception =   assertThrows(
                EmployeeStorageIsFullException.class, () -> employeeServiceimpl.add(firstName, lastName, salary, department)
        );
        assertEquals(expectedMessage,exception.getMessage());

    }
}