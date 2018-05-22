/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mentat
 */
public class ConexionBD {

Connection conn;    
String url = "jdbc:postgresql://localhost:5432/WorldBikers";
String user = "Miguel";
String passw = "Ar10c0";
Statement st;
ResultSet rs;
String query;




    public ConexionBD() {
        try {
            Class.forName("org.postgresql.Driver"); 
            this.conn = DriverManager.getConnection(url, user, passw);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public ResultSet consulta (String query){
        
        try {
            System.out.println("En conexionBD consultaSimple");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            conn.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    public void crearCliente (String query){
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int maxId (){
        
        query = "SELECT max(id) FROM users;";
    try {
        st = conn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        rs = st.executeQuery(query);
    } catch (SQLException ex) {
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    int max = 0;
    try {
        while (rs.next()){
            try {
                max = rs.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return max+1;    
    }

    public void modificarCliente (String query){
        try {
            st = conn.createStatement();
            int modif = st.executeUpdate(query);
            System.out.println("modif = " + modif);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ResultSet consultaMultiple (String query){
            try {
                st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs = st.executeQuery(query);            
                conn.close();
                
                return rs;
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                return rs;
            }
    }    
}