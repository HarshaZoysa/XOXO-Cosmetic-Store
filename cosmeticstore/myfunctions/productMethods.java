/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticstore.myfunctions;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;




/**
 *
 * @author Business
 */
public class productMethods {
    
    public void addProduct(product product) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO product_table (SKU, productName, qty, price, category) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, product.getSku());
                pstmt.setString(2, product.getProductName());
                pstmt.setInt(3, product.getQuantity());
                pstmt.setDouble(4, product.getPrice());
                pstmt.setString(5, product.getCategory());
                pstmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Product Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }}
