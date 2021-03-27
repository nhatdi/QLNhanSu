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
public class TruyVan {
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
            String hostname = "GUNH\\SQLEXPRESS";
            String dbName = "Polypro";
            Connection con = TruyVan.ketNoi(hostname, dbName);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM NhanVien";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String ma = rs.getString(1);
                String mk = rs.getString(2);
                String hoTen = rs.getString(3);
                boolean vt = rs.getBoolean(4);
                String vT;
                if(vt == true){
                    vT = "Trưởng phòng";
                }else{
                    vT = "Nhân viên";
                }
                System.out.println("-------------------");
                System.out.println("Mã NV: "+ma);
                System.out.println("Mật khẩu: "+mk);
                System.out.println("Họ tên: "+hoTen);
                System.out.println("Vai trò: "+vT);
            }
            con.close();
        } catch (Exception e) {
        }
    }
}
