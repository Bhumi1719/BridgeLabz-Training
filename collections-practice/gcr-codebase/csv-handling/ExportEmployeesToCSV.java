import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ExportEmployeesToCSV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter output CSV file path: ");
        String csvFilePath = sc.nextLine();

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // replace with your DB
        String username = "root"; // DB username
        String password = "password"; // DB password
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            FileWriter csvWriter = new FileWriter(csvFilePath)) {

            // Writing CSV header
            csvWriter.append("Employee ID,Name,Department,Salary\n");

            // Writing rows
            while(resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String dept = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                csvWriter.append(String.valueOf(id))
                        .append(",")
                        .append("\"").append(name).append("\"")
                        .append(",")
                        .append(dept)
                        .append(",")
                        .append(String.valueOf(salary))
                        .append("\n");
            }

            System.out.println("CSV report generated successfully at: " + csvFilePath);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
