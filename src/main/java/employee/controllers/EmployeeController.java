package employee.controllers;

import employee.model.Employee;
import employee.repository.EmployeeStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeStorage employees = new EmployeeStorage();

    @PostMapping
    public ResponseEntity<Employee> add(Employee inData) {
        Employee employee = null;
        if (!inData.getName().isEmpty()) {
            employee = employees.add(inData.getName(), inData.getRole());
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> list() {
        return ResponseEntity.ok(employees.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable int id) {
        return ResponseEntity.ok(employees.find(id));
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        return employees.delete(id); // возвращает true в случае успеха
    }

    @PutMapping
    public ResponseEntity<Employee> edit(Employee employee) {
        return ResponseEntity.ok(employees.edit(employee));
    }

}
