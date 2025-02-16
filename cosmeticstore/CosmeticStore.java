import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
/**
 * This class is used to create a JDBC 
 * connection with MySql DB.
 * @author w3spoint
 */
public class CosmeticStore {
	//JDBC and database properties.
	private static final String DB_DRIVER = 
		           "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = 
		        "jdbc:mysql://localhost:3306/cosmeticstore";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
 
	public static void main(String args[]){
		Connection conn = null;
                
            String tableName = "myAss";
            String column1 = "Id";
            String column1Type = "int";
            String column2 = "name";
            String column2Type = "varchar(30)";
		try{
			//Register the JDBC driver
			Class.forName(DB_DRIVER);
 
			//Open the connection
			conn = DriverManager.
			getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                        Statement stmt = conn.createStatement();
			if(conn != null){
			   System.out.println("Successfully connected.");
                           String query = "create table " + tableName + " ( " + column1+" " + column1Type +  " , " +
                    column2 +" " + column2Type + " )";
                                       stmt.executeUpdate(query);
            stmt.close();

                           
                           
			}else{
			   System.out.println("Failed to connect.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
        
        
        
}


