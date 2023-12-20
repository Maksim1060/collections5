package pro.sky.skyprocollections5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocollections5.model.Employee;
import pro.sky.skyprocollections5.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/")

public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int salary, @RequestParam int department) {
        return service.add(firstName, lastName,salary,department);

    }

    @GetMapping("/remove")
    public Employee removeEmploye(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);

    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();

    }
}