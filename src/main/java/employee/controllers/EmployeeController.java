package employee.controllers;

import employee.model.Employee;
import employee.model.EmployeeRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeSet;

@RestController
public class EmployeeController {

    EmployeeRepository employees = new EmployeeRepository();

    public EmployeeController() {

    }

}
