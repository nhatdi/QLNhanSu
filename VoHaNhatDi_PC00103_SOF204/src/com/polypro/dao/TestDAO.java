/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polypro.dao;

import com.polypro.model.NguoiHoc;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author DELL
 */
public class TestDAO {

    public static void Insert() {
        try {
            NguoiHoc model = new NguoiHoc();
            NguoiHocDAO dao = new NguoiHocDAO();
            model.setMaNH("PC00103");
            model.setHoTen("Võ Hà Nhật Di");
            model.setNgaySinh(java.sql.Date.valueOf("2000-03-07"));
            model.setGioiTinh(true);
            model.setDienThoai("0963199344");
            model.setEmail("divhnpc00103@fpt.edu.vn");
            model.setGhiChu("0963199344 - Võ Hà Nhật Di");
            model.setMaNV("Divhn");
            model.setNgayDK(java.sql.Date.valueOf("2019-10-01"));
            dao.insert(model);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update() {
        try {
            NguoiHoc model = new NguoiHoc();
            NguoiHocDAO dao = new NguoiHocDAO();
            model.setHoTen("Võ Hà Nhật Di");
            model.setNgaySinh(java.sql.Date.valueOf("2000-03-07"));
            model.setGioiTinh(true);
            model.setDienThoai("0963199344");
            model.setEmail("divhnpc00103@fpt.edu.vn");
            model.setGhiChu("0963199344 - Võ Hà Nhật Di");
            model.setMaNV("Divhn");
            model.setNgayDK(java.sql.Date.valueOf("2019-10-01"));
            model.setMaNH("PC00103");
            dao.update(model);
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
        }
    }

    public static void Delete() {
        try {
            NguoiHocDAO dao = new NguoiHocDAO();
            dao.delete("PC00103");
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TruyVanID() {
        try {
            NguoiHocDAO dao = new NguoiHocDAO();
            NguoiHoc model = new NguoiHoc();
            System.out.println(model.getMaNH());
            System.out.println(model.getHoTen());
            System.out.println(model.getNgaySinh());
            System.out.println(model.isGioiTinh() ? "Nam" : "Nữ");
            System.out.println(model.getDienThoai());
            System.out.println(model.getEmail());
            System.out.println(model.getGhiChu());
            System.out.println(model.getMaNV());
            System.out.println(model.getNgayDK());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TruyVanTatCa() {
        try {
            NguoiHocDAO dao = new NguoiHocDAO();
            List<NguoiHoc> nh = dao.select();
            for (NguoiHoc model : nh) {
                System.out.print(model.getMaNH());
                System.out.print(" | " + model.getHoTen());
                System.out.print(" | " + model.getNgaySinh() + " | ");
                System.out.print(model.isGioiTinh() ? "Nam" : "Nữ");
                System.out.print(" | " + model.getDienThoai());
                System.out.print(" | " + model.getEmail());
                System.out.print(" | " + model.getGhiChu());
                System.out.print(" | " + model.getMaNV());
                System.out.println(" | " + model.getNgayDK());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ThuTuc() {
        System.out.println(new ThongKeDAO().getNguoiHoc());
    }

    public static void main(String[] args) {
        Insert();
        Update();
        Delete();
        TruyVanID();
        TruyVanTatCa();
        ThuTuc();
    }
}
