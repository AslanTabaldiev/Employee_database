import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();

        Employee employee = new Employee("Nazar", "Java developer", 50000.0, new Date());
        employeeData.createEmployee(employee);

        Employee retrievedEmployee = employeeData.getEmployeeById(4);
        System.out.println("Retrieved Employee: " + '\n' + retrievedEmployee);

        System.out.println("All Employees: ");
        employeeData.getAllEmployees().forEach(System.out::println);

        int idToUpdate = 4;
        Employee existingEmployee = employeeData.getEmployeeById(idToUpdate);

        if (existingEmployee != null) {
            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(idToUpdate);
            updatedEmployee.setName("Nazar");
            updatedEmployee.setPosition("Senior Developer");
            updatedEmployee.setSalary(200000.0);
            updatedEmployee.setHireDate(new Date());

            employeeData.updateEmployee(updatedEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee with ID " + idToUpdate + " does not exist.");
        }

        employeeData.deleteEmployee(2);
    }
}