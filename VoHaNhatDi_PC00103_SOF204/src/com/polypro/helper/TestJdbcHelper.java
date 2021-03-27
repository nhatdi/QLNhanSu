/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polypro.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class TestJdbcHelper {

    public static void Insert() {
        try {
            String sql = "INSERT INTO NguoiHoc VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = JdbcHelper.prepareStatement(sql);
            JdbcHelper.executeUpdate(sql, "PC00103", "Võ Hà Nhật Di",
                    java.sql.Date.valueOf("2000-03-07"), true, "0963199344",
                    "divhnpc00103@fpt.edu.vn", "0963199344 - Võ Hà Nhật Di", "Divhn",
                    java.sql.Date.valueOf("2019-10-01"));
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update() {
        try {
            String sql = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?,\n"
                    + "DienThoai=?, Email=?, GhiChu=?, MaNV=?, NgayDK=? WHERE MaNH=?";
            PreparedStatement st = JdbcHelper.prepareStatement(sql);
            JdbcHelper.executeUpdate(sql, "Nhật Di",
                    java.sql.Date.valueOf("2000-03-07"), true, "0963199344",
                    "divhnpc00103@fpt.edu.vn", "Nhật Di", "DIvhn",
                    java.sql.Date.valueOf("2019-10-01"), "PC00103");
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Delete() {
        try {
            String sql = "DELETE FROM NguoiHoc WHERE MaNH=?";
            PreparedStatement st = JdbcHelper.prepareStatement(sql);
            JdbcHelper.executeUpdate(sql, "PC00103");
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TruyVanID() {
        try {
            String sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
            ResultSet rs = JdbcHelper.executeQuery(sql, "PC00103");
            while (rs.next()) {
                System.out.println("Thông tin người học có mã: " + rs.getString(1));
                System.out.println("HoTen: " + rs.getString(2));
                System.out.print("NgaySinh: " + rs.getDate(3) + "\nGioiTinh: ");
                System.out.println(rs.getBoolean(4) ? "Nam" : "Nữ");
                System.out.println("SoDienThoai: " + rs.getString(5));
                System.out.println("Email: " + rs.getString(6));
                System.out.println("GhiChu: " + rs.getString(7));
                System.out.println("MaNV: " + rs.getString(8));
                System.out.println("NgayDK: " + rs.getDate(9));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TruyVanTatCa() {
        try {
            String sql = "SELECT * FROM NguoiHoc";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                System.out.print("MaNH: " + rs.getString(1));
                System.out.print(" | HoTen: " + rs.getString(2));
                System.out.print(" | NgaySinh:  " + rs.getDate(3) + " | GioiTinh: ");
                System.out.print(rs.getBoolean(4) ? "nam" : "nữ");
                System.out.print(" | DienThoai: " + rs.getString(5));
                System.out.print(" | Email: " + rs.getString(6));
                System.out.print(" | GhiChu: " + rs.getString(7));
                System.out.print(" | MaNV: " + rs.getString(8));
                System.out.println(" | NgayDK: " + rs.getDate(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ThuTuc() {
        try {
            String sql = "{call sp_ThongKeNguoiHoc}";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            System.out.println(" Thống kê người học ");
            while (rs.next()) {
                System.out.print(" Năm: " + rs.getString(1));
                System.out.print(" | Số Người Học: " + rs.getString(2));
                System.out.print(" | Đầu Tiên: " + rs.getDate(3));
                System.out.println(" | Cuối Cùng: " + rs.getDate(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Insert();
//        Update();
//        Delete();
//        TruyVanID();
//        TruyVanTatCa();
//        ThuTuc();

    }
}
