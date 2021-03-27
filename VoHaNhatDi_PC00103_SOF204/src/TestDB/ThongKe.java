/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class ThongKe {
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
            Connection con = ThongKe.ketNoi(ten_mien, ten_csdl);
            Statement st = con.createStatement();
            String sql = "SELECT   YEAR(NgayDK) Nam,COUNT(*) SoLuong,MIN(NgayDK) DauTien,MAX(NgayDK) CuoiCung  \n" +
                            "FROM NguoiHoc  \n" +
                            "GROUP BY YEAR(NgayDK)";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int nam = rs.getInt(1);
                int sLuong = rs.getInt(2);
                String dTien = rs.getString(3);
                String cCung = rs.getString(4);
                System.out.println("Năm: "+nam);
                System.out.println("Số lượng: "+sLuong);
                System.out.println("Ngày đầu tiên: "+dTien);
                System.out.println("Ngày cuối cùng: "+cCung);
                System.out.println("----------------------------");
            }
            con.close();
        } catch (Exception e) {
        }
    }
}
