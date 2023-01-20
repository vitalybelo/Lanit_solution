package employee.controllers;

import employee.model.Employee;
import employee.model.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employees = new EmployeeRepository();

    @PostMapping("/employee/")
    int add(Employee employee) {
        String name = employee.getName();
        String role = employee.getRole();
        if (!name.isEmpty()) {
            System.out.println(employees.toString());
            return employees.addEmployee(name, role); // возвращаем id добавленного сотрудника
        }
        return -1; // данных в запросе нет, добавлять не будем
    }

    @GetMapping("/employee/")
    List<Employee> list() {
        return employees.getEmployeeList();
    }

    @GetMapping("/employee/{id}")
    Employee get(@PathVariable int id) {
        return employees.getEmployee(id);
    }


}
