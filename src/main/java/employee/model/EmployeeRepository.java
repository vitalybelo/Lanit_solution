package employee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeRepository {

    private int idCounter;
    private final Map<Integer, Employee> employees = new TreeMap<>();

    public EmployeeRepository() {
        this.idCounter = 0;
    }

    public int addEmployee(String name, String role) {
        idCounter++;
        Employee employee = new Employee(idCounter, name, role);
        employees.put(idCounter, employee);
        return idCounter;
    }

    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployee(int id) {
        if (employees.containsKey(id)) {
            return employees.get(id);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Список сотрудников:\n");
        for (Employee e : new ArrayList<>(employees.values())) {
            s.append(e.getName()).append(" :: ").append(e.getRole()).append("\n");
        }
        return s.toString();
    }
}
