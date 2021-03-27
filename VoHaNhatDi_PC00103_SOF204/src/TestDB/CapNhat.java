/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class CapNhat {

    public static Connection ketNoi(String ten_mien, String ten_csdl) {
        try {
            String URL = "jdbc:sqlserver://" + ten_mien
                    + ";databaseName="
                    + ten_csdl + ";integratedSecurity=true";
            Connection conn = DriverManager.getConnection(URL);
            return conn;
        } catch (SQLException ex) {

        }
        return null;
    }
     public static void main(String[] args) {
        try {
            String ten_mien = "GUNH\\SQLEXPRESS";
            String ten_csdl = "Polypro";
            Connection con = CapNhat.ketNoi(ten_mien, ten_csdl);
            String sql = "Update NhanVien set MatKhau=?,HoTen=?,VaiTro=?\n" +
                         "where MaNV=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(4, "DiVHN");
            st.setString(1, "123456");
            st.setString(2, "Nhật Di");
            st.setBoolean(3, true);
            st.executeUpdate();
            System.out.println("Cập nhật thành công");
            con.close();
        } catch (Exception e) {
        }
    }
}
