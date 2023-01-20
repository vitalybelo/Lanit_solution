package employee.model;
import lombok.Getter;

@Getter
public class Employee {

    private int id = 0;
    private String name = "";
    private String role = "";

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

}
