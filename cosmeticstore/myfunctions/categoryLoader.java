/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticstore.myfunctions;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Business
 */
public class categoryLoader {
    
    public void loadCatagory(JComboBox<String> comboBox){
    
    Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
       try {
            con = DatabaseConnection.getConnection();
            String sql = "SELECT categoryName FROM categories";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            comboBox.removeAllItems(); // Clear existing items
            ArrayList<String> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(rs.getString("categoryName"));
            }

            for (String category : categories) {
                comboBox.addItem(category);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  

    
    
    
    }
    
    public void loadCategoriesToTable(JTable categoryTable) {
        String sql = "SELECT * FROM categories";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Get the table model
            DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();

            // Clear existing rows
            model.setRowCount(0);

            // Retrieve data and add to the table model
            while (rs.next()) {
              
                String categoryName = rs.getString("categoryName");

                model.addRow(new Object[]{categoryName});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
