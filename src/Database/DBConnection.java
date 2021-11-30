/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnection {

    String connString = "jdbc:mysql://localhost:3306/javauneti";

    public Connection GetConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(connString,"root","");
            return conn;
        } catch (SQLException ex) {
           Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet GetData(String query) {
        Connection conn = GetConnection();
        if (conn == null) //nếu không thể mở kết nối
        {
            CloseConnection(conn); //Đóng kết nối
            return null;
        }
        Statement stm;
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            CloseConnection(conn); //đóng kết nối
            return null;
        }
    }

    public boolean UpdateData(String query) {
        Connection conn = GetConnection();
        if (conn == null) {
            return false;
        }
        Statement stm;
        try {
            stm = conn.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void CloseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
