
package cosmeticstore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;




public class DataBaseSetup {
    
   private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Replace with your MySQL root password

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Create database if not exists
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS cosmeticstore";
            statement.executeUpdate(createDatabaseSQL);

            // Use the created database
            String useDatabaseSQL = "USE cosmeticstore";
            statement.executeUpdate(useDatabaseSQL);

            // Create users table
            String createUsersTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                                         "UserName VARCHAR(50), " +
                                         "EmployeeID VARCHAR(50), " +
                                         "EmployeeName VARCHAR(50), " +
                                         "Role VARCHAR(50), " +
                                         "Password VARCHAR(50))";
            statement.executeUpdate(createUsersTableSQL);

            // Insert initial user
            String insertUserSQL = "INSERT INTO users (UserName, EmployeeID, EmployeeName, Role, Password) " +
                                   "VALUES ('root', 'root', 'root', 'Manager', 'root')";
            statement.executeUpdate(insertUserSQL);

            // Create categories table
            String createCategoriesTableSQL = "CREATE TABLE IF NOT EXISTS categories (" +
                                              "categoryName VARCHAR(50))";
            statement.executeUpdate(createCategoriesTableSQL);

            // Insert initial categories
            String[] categories = {"Body Lotion", "Conditioner", "Face Cream", "Foundation", "Hair Oil", 
                                   "Lipstick", "Mascara", "Nail Polish", "Shampoo", "Sunscreen"};
            for (String category : categories) {
                String insertCategorySQL = "INSERT INTO categories (categoryName) VALUES ('" + category + "')";
                statement.executeUpdate(insertCategorySQL);
            }

            // Create product_table
            String createProductTableSQL = "CREATE TABLE IF NOT EXISTS product_table (" +
                                           "SKU VARCHAR(50), " +
                                           "productName VARCHAR(50), " +
                                           "qty INT, " +
                                           "price DOUBLE, " +
                                           "category VARCHAR(50))";
            statement.executeUpdate(createProductTableSQL);

            System.out.println("Database and tables created successfully!");

            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
    } 
    
    
    
    
    
    
}
