package employee.model;
import lombok.Getter;

@Getter
public class Employee {

    private String name = "";
    private String role = "";

    public Employee() {
        this("","");
    }

    public Employee(String name, String role) {
        setName(name);
        setRole(role);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            name = "Unknown";
        }
        this.name = name;
    }

    public void setRole(String role) {
        if (role.isEmpty()) {
            role = "Unknown";
        }
        this.role = role;
    }

}
