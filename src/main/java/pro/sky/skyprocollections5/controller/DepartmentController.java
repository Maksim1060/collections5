package pro.sky.skyprocollections5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocollections5.model.Employee;
import pro.sky.skyprocollections5.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departmens")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }
@GetMapping(value = "/all",params = {"departmentId"})
    public Collection<Employee> gerEmployees(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeByDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployeeByDepartment();
    }
}