/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Models.Login;
import Utils.JdbcUtil;
import java.util.ArrayList;
import java.sql.*;

public class LoginRepository {
    public ArrayList<Login> selectAll() {
        ArrayList<Login> list = new ArrayList<>();
        try {
        Connection conn = JdbcUtil.getConnection();
        String query = "SELECT * FROM users";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                
                String username = rs.getString("username");
                String password = rs.getString("pass_word");
                Login l = new Login(username, password);
                list.add(l);
            }
            
            System.out.println("truy van thành công");
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return list;
    }

}
