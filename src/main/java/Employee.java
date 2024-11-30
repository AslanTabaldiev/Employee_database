import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private Date hireDate;

    public Employee() {}

    public Employee(String name, String position, double salary, Date hireDate) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee(int id, String name, String position, double salary, Date hireDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" + '\n' +
                "         id = " + id + '\n' +
                "         name = '" + name + "'" + '\n' +
                "         position = '" + position + "'" + '\n' +
                "         salary = " + salary + '\n' +
                "         hireDate = " + hireDate + '\n' +
                '}';
    }
}

