package employee;

import employee.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeStorage {

    private int idCounter;
    private final Map<Integer, Employee> employees = new TreeMap<>();

    public EmployeeStorage() {
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

    public boolean deleteEmployee(int id) {
        return employees.remove(id) != null;
    }

    public int editEmployee(Employee employee) {
        int id = employee.getId();
        if (employees.containsKey(id)) {
            employees.get(id).setName(employee.getName());
            employees.get(id).setRole(employee.getRole());
            return id;
        }
        return -1;
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
