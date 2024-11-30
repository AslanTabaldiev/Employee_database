import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/employee_db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, position, salary, hire_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setString(1, employee.getName());
            pstatement.setString(2, employee.getPosition());
            pstatement.setDouble(3, employee.getSalary());
            pstatement.setDate(4, new java.sql.Date(employee.getHireDate().getTime()));
            pstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setInt(1, id);
            ResultSet rs = pstatement.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection connection = getConnection();
             Statement pstatement = connection.createStatement();
             ResultSet rs = pstatement.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, position = ?, salary = ?, hire_date = ? WHERE id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setString(1, employee.getName());
            pstatement.setString(2, employee.getPosition());
            pstatement.setDouble(3, employee.getSalary());
            pstatement.setDate(4, new java.sql.Date(employee.getHireDate().getTime()));
            pstatement.setInt(5, employee.getId());
            pstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
