package employee.model;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeRepository {

    private int idCounter;
    private final Map<Integer, Employee> employees = new TreeMap<>();

    public EmployeeRepository() {
        this.idCounter = 1;
    }

    public void addEmployee(String name, String role) {
        Employee employee = new Employee(name, role);
        employees.put(idCounter, employee);
        idCounter++;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {


        return new Employee();
    }

}
