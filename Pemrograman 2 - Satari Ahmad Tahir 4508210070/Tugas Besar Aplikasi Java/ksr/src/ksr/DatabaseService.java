/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ksr;

import java.security.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author jimmy
 */
public class DatabaseService {
    public String login(String uname, String pass) throws Exception {
        
        // 0. Variabel untuk koneksi
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost/kasir";
        String dbUser = "root";
        String dbPass = "";
        String login = "";
        
        byte[] bytesOfMessage = pass.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        
        
        // 1. Aktivasi driver database
        Class.forName(dbDriver);

        // 2. Connect ke database
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        
        String sql2 = "select *from admin where username = '" + uname + "' && password ='" + pass + "'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs = ps2.executeQuery();

        //List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
        while(rs.next()) {
            login = rs.getString("username");
        }
        
        rs.close();
        conn.close();
        return login;
    }
    
    public Vector getMakanan () throws ClassNotFoundException, SQLException {
        Vector makanan = new Vector();
        
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost/kasir";
        String dbUser = "root";
        String dbPass = "";
        String login = "";
        
        // 1. Aktivasi driver database
        Class.forName(dbDriver);

        // 2. Connect ke database
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        
        String sql2 = "select * from makanan;";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs = ps2.executeQuery();
        
        //List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
       
        while(rs.next()){
        //Retrieve by column name
            Vector data = new Vector();
            data.add(rs.getInt("id"));
            data.add(rs.getString("makan"));
            data.add(rs.getInt("harga"));
            
            makanan.add(data);
        }
        
        rs.close();
        conn.close();       
        return makanan;
    }
    
    /*
    public String insertTrans (String id_mkn, String id_min, String id_stat) {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost/kasir";
        String dbUser = "root";
        String dbPass = "";
        String login = "";
        
        byte[] bytesOfMessage = pass.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        
        
        // 1. Aktivasi driver database
        Class.forName(dbDriver);

        // 2. Connect ke database
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        
        String sql2 = "select *from admin where username = '" + uname + "' && password ='" + pass + "'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs = ps2.executeQuery();

        //List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
        while(rs.next()) {
            login = rs.getString("username");
        }
        
        rs.close();
        conn.close();
        return login;
        
    }
    * */
}

