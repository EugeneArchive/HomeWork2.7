package com.example.HomeWork27.Controller;

import com.example.HomeWork27.Employee;
import com.example.HomeWork27.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/print")
    public List<Employee> printEmployee() {
        return employeeService.printEmployee();

    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        employeeService.addEmployees(surname, name);
        return surname + " " + name + " добавлен.";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("surname") String surname, @RequestParam("name") String name) {

        employeeService.removeEmployees(surname, name);
        return surname + " " + name + " удален.";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        employeeService.findEmployees(surname, name);
        return surname + " " + name + " найден.";
    }
}
