package cosmeticstore.myfunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdMethods implements ProductActions {
    
    @Override
    public void deleteProduct(String sku) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM product_table WHERE SKU = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, sku);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Product Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "No Product Found with SKU: " + sku);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
