/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Models.Students;
import Utils.JdbcUtil;
import java.sql.*;
import java.util.ArrayList;

public class StudentsRepository {
    public void insert(Students hs) {
        try {
            Connection conn = JdbcUtil.getConnection();
            
            String query = "INSERT INTO students(masv, hoten, email, sodt, gioitinh, diaChi, hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, hs.getMaSv());
            ps.setString(2, hs.getHoTen());
            ps.setString(3, hs.getEmail());
            ps.setString(4, hs.getSoDT());
            ps.setInt(5, hs.getGioiTinh().equals("Nam") ? 0 : 1);
            ps.setString(6, hs.getDiaChi());
            ps.setString(7, hs.getHinh());
            
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String masv, Students hs) {
        try {
            Connection conn = JdbcUtil.getConnection();
            
            String query = "UPDATE students SET masv = ?, hoten = ?, email = ?, sodt = ?, gioitinh = ?, diaChi = ?, hinh = ? WHERE masv = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, hs.getMaSv());
            ps.setString(2, hs.getHoTen());
            ps.setString(3, hs.getEmail());
            ps.setString(4, hs.getSoDT());
            ps.setInt(5, hs.getGioiTinh().equals("Nam") ? 0 : 1);
            ps.setString(6, hs.getDiaChi());
            ps.setString(7, hs.getHinh());
            ps.setString(8, masv);
            
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String masv) {
        try {
            Connection conn = JdbcUtil.getConnection();
            
            String query1 = "DELETE FROM grade WHERE masv = ?";
            PreparedStatement ps1 = conn.prepareStatement(query1);
            ps1.setString(1, masv);
            ps1.execute();
            
            String query = "DELETE FROM students WHERE masv = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, masv);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Students> selectAll() {
        ArrayList<Students> list = new ArrayList<>();
        try {
        Connection conn = JdbcUtil.getConnection();
        String query = "SELECT * FROM students";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                String masv = rs.getString("masv");
                String ten = rs.getString("hoten");
                String email = rs.getString("email");
                String sdt = rs.getString("sodt");
                String gioiTinh = rs.getInt("gioitinh") == 0 ? "Nam" : "Nu";
                String diachi = rs.getString("diaChi");
                String hinh = rs.getString("hinh");
                Students kh = new Students(masv, ten, email, sdt, gioiTinh, diachi, hinh);
                list.add(kh);
            }
            
            System.out.println("truy van thành công");
            
        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
