package employee.model;

import employee.model.Employee;
import java.util.*;

/**
 * Класс примитивно имитирует работу с таблицей в базе данных
 * Содержит счетчик id записей, карту записей и ключом по счетчику
 * Реализует методы:
 * - добавление сотрудника в таблицу
 * - удаление сотрудника из таблицы
 * - поиск сотрудника по id
 * - формирование коллекции всех сотрудников
 * - замена данных о сотруднике по значению id
 */
public class EmployeeStorage {

    private int idCounter;
    private final Map<Integer, Employee> employees = new HashMap<>();

    public EmployeeStorage() {
        this.idCounter = 0;
    }

    public int add(String name, String role) {
        idCounter++;
        Employee employee = new Employee(idCounter, name, role);
        employees.put(idCounter, employee);
        return idCounter;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee find(int id) {
        if (employees.containsKey(id)) {
            return employees.get(id);
        }
        return null;
    }

    public boolean delete(int id) {
        return employees.remove(id) != null;
    }

    public int edit(Employee employee) {
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
