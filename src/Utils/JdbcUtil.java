/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.*;

public class JdbcUtil {
    private static Connection conn;
    
    public static Connection getConnection() {
        if(JdbcUtil.conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
                String dbUser = "sa", dbPass = "123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=FPL_DaoTao;encrypt=true;trustServerCertificate=true";

                JdbcUtil.conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        
                System.out.println("Kết nối thành công");
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return JdbcUtil.conn;
    }
}
