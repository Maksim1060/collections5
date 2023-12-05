package pro.sky.skyprocollections5.service;
import static pro.sky.skyprocollections5.service.EmployeeGenerator.*;

import com.sun.jdi.event.ExceptionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.handler.MappedInterceptor;
import pro.sky.skyprocollections5.exception.EmployeeNotFoundException;
import pro.sky.skyprocollections5.model.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImpITest {
    @Mock
    private EmployeeServiceimpl employeeServiceimpl;
    @InjectMocks
    private DepartmentServiceImpI getDepartmentServiceImpI;


    @Test
    void getEmployeeWithMaxSalary() {
        Integer departmentId =FIRST_DEPARTMENT_ID;
        when(employeeServiceimpl.findAll()).thenReturn(getAllEmployee());
        Employee expectedEmployee= EmployeeGenerator.getEmployee();
        Employee actualEmployee = getDepartmentServiceImpI.getEmployeeWithMaxSalary(departmentId);
        assertEquals(expectedEmployee,actualEmployee);
        assertTrue(expectedEmployee.getSalary()>getEmployee2().getSalary());
    }

    @Test
    void getEmployeeWithMinSalary() {
        Integer departmentId =FIRST_DEPARTMENT_ID;
        when(employeeServiceimpl.findAll()).thenReturn(getAllEmployee());
        Employee expectedEmployee= getEmployee2();
        Employee actualEmployee = getDepartmentServiceImpI.getEmployeeWithMinSalary(departmentId);
        assertEquals(expectedEmployee,actualEmployee);
        assertTrue(EmployeeGenerator.getEmployee().getSalary()>getEmployee2().getSalary());
    }

    @Test
    void getEmployee() {
        Integer departmentId =FIRST_DEPARTMENT_ID;
        when(employeeServiceimpl.findAll()).thenReturn(getAllEmployee());
        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(FIRST_DEPARTMENT_ID, Arrays.asList(getEmployee2(), EmployeeGenerator.getEmployee()));
        Map<Integer, List<Employee>> actualMap = (Map<Integer, List<Employee>>) getDepartmentServiceImpI.getEmployee(departmentId);
        assertEquals(actualMap,expectedMap);

    }

    @Test
    void getEmployeeDepartment_withoutDepartmentId() {
        Integer departmentId = null;
        when(employeeServiceimpl.findAll()).thenReturn(getAllEmployee());
        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
      expectedMap.put(FIRST_DEPARTMENT_ID,Arrays.asList(EmployeeGenerator.getEmployee(),getEmployee2()));
        expectedMap.put(FIRST_DEPARTMENT_ID, Collections.singletonList(getEmployee3()));
        Map<Integer, List<Employee>> actualMap = getDepartmentServiceImpI.getEmployee();
        assertEquals(expectedMap,actualMap);

    }


    @Test
    void getEmployeeWithMaxSalary_withEmployeeNotFoundException() {
        Integer departmentId=FIRST_DEPARTMENT_ID;
        when(employeeServiceimpl.findAll()).thenReturn(Collections.emptyList());
        String expectedMessage = "Employee not found";
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> getDepartmentServiceImpI.getEmployeeWithMaxSalary(departmentId));
        assertEquals(expectedMessage,exception.getMessage());
    }

    @Test
    void getEmployeeWithMinSalary_withEmployeeNotFoundException() {
        Integer departmentId=FIRST_DEPARTMENT_ID;
        when(employeeServiceimpl.findAll()).thenReturn(Collections.emptyList());
        String expectedMessage = "Employee not found";
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> getDepartmentServiceImpI.getEmployeeWithMinSalary(departmentId));
        assertEquals(expectedMessage,exception.getMessage());
    }
}