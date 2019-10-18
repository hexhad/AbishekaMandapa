/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Hash
 */
public class SQLConnection {
    Connection conn =null;
    public static Connection ConnectDB(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/abisheka","root","");
        //JOptionPane.showMessageDialog(null, "CONNECTED");
        return conn;
        
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null; 
        
        }
    }
}
