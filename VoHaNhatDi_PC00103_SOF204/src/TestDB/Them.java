/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class Them {
    
    public static Connection ketNoi(String ten_mien,String ten_csdl){
        try {
            String URL = "jdbc:sqlserver://" + ten_mien
                    + ";databaseName="
                    + ten_csdl+ ";integratedSecurity=true";
            Connection conn = DriverManager.getConnection(URL);
            return conn;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public static void main(String[] args) {
        try {
            String ten_mien = "GUNH\\SQLEXPRESS";
            String ten_csdl= "Polypro";
            Connection con = Them.ketNoi(ten_mien, ten_csdl);
            String sql = "Insert into NhanVien values (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "DiVHN");
            st.setString(2, "123456");
            st.setString(3, "Võ Hà Nhật Di");
            st.setBoolean(4, true);
            st.executeUpdate();
            System.out.println("Thêm thành công");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

