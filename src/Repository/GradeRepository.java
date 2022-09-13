/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Models.Grade;
import Utils.JdbcUtil;
import  java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GradeRepository {
    public boolean insert(Grade g) {

        try {
            Connection conn = JdbcUtil.getConnection();
            
            if(Ten(g.getMaSV()) != null) {
            String query = "INSERT INTO grade(masv, tieng_anh, tin_hoc, gdtc) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, g.getMaSV());
            ps.setDouble(2, g.getDiemTA());
            ps.setDouble(3, g.getDiemTH());
            ps.setDouble(4, g.getDiemGDTC());
            
            ps.execute();
            return true;
            } 
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void update(String masv, Grade g) {
        try {
            Connection conn = JdbcUtil.getConnection();
            
            String query = "UPDATE grade SET masv = ?, tieng_anh = ?, tin_hoc = ?, gdtc = ? WHERE masv = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, g.getMaSV());
            ps.setDouble(2, g.getDiemTA());
            ps.setDouble(3, g.getDiemTH());
            ps.setDouble(4, g.getDiemGDTC());
            ps.setString(5, masv);
            
            ps.execute();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String masv) {
        try {
            Connection conn = JdbcUtil.getConnection();
            
            String query = "DELETE FROM grade WHERE masv = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, masv);
            
            ps.execute();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Grade> selectAll() {
        ArrayList<Grade> list = new ArrayList<>();
        try {
        Connection conn = JdbcUtil.getConnection();
        String query = "SELECT * FROM grade";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                
                String masv = rs.getString("masv");
                double tiengAnh = rs.getDouble("tieng_anh");
                double tinHoc = rs.getDouble("tin_hoc");
                double gdtc = rs.getDouble("gdtc");
                Grade g = new Grade(masv, tiengAnh, tinHoc, gdtc);
                list.add(g);
            }
            
            System.out.println("truy van thành công");
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return list;
    }
    
    public ArrayList<Grade> selectTop3() {
        ArrayList<Grade> list = new ArrayList<>();
        try {
        Connection conn = JdbcUtil.getConnection();
        String query = "SELECT TOP 3 id, masv, tieng_anh, tin_hoc, gdtc FROM grade \n" +
                       "GROUP BY id, masv, tieng_anh, tin_hoc, gdtc\n" +
                       "ORDER BY (tieng_anh + tin_hoc + gdtc)/3 DESC";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                String masv = rs.getString("masv");
                double tiengAnh = rs.getDouble("tieng_anh");
                double tinHoc = rs.getDouble("tin_hoc");
                double gdtc = rs.getDouble("gdtc");
                Grade g = new Grade(masv, tiengAnh, tinHoc, gdtc);
                list.add(g);
            }
            
            System.out.println("truy van thành công");
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return list;
    }
    
    public String Ten(String masv) {
        
        String ten = "";
        
        try {
        Connection conn = JdbcUtil.getConnection();
        String query = "SELECT hoten FROM students WHERE masv = ?";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, masv);
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
            
        while (rs.next() == true) {

        ten = rs.getString("hoten");
        }
        System.out.println("truy van thành công");
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return ten;
    }
}
