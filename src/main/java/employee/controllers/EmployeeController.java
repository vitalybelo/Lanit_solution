package employee.controllers;

import employee.model.Employee;
import employee.model.EmployeeStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeStorage employees = new EmployeeStorage();

    @PostMapping
    public int add(Employee employee) {
        if (!employee.getName().isEmpty()) {
            // возвращаем id добавленного сотрудника
            return employees.add(employee.getName(), employee.getRole());
        }
        return -1; // данных в запросе нет, добавлять не будем
    }

    @GetMapping
    public ResponseEntity<List<Employee>> list() {
        return ResponseEntity.ok(employees.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable int id) {
        Employee employee = employees.find(id);
        if (employee == null) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(employees.find(id));
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        return employees.delete(id); // возвращает true в случае успеха
    }

    @PutMapping
    public int edit(Employee employee) {
        return employees.edit(employee);
    }

}
