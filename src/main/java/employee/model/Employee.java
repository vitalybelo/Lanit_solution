package employee.model;
import lombok.Getter;

@Getter
public class Employee {

    private int id;             // id сотрудника
    private String name = "";   // имя сотрудника
    private String role = "";   // должность сотрудника

    public Employee() {
        this(0,"","");
    }

    public Employee(String name, String role) {
        this(0, name, role);
    }

    public Employee(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

}
