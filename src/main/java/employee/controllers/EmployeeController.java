package employee.controllers;

import employee.model.Employee;
import employee.EmployeeStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeStorage employees = new EmployeeStorage();

    @PostMapping("/employee/")
    public int add(Employee employee) {
        if (!employee.getName().isEmpty()) {
            // возвращаем id добавленного сотрудника
            return employees.addEmployee(employee.getName(), employee.getRole());
        }
        return -1; // данных в запросе нет, добавлять не будем
    }

    @GetMapping("/employee/")
    public List<Employee> list() {
        return employees.getEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id) {
        return employees.getEmployee(id);
    }

    @DeleteMapping("/employee/{id}")
    public boolean delete(@PathVariable int id) {
        return employees.deleteEmployee(id); // возвращает true в случае успеха
    }

    @PutMapping("/employee/")
    public int edit(Employee employee) {
        return employees.editEmployee(employee);
    }

}
