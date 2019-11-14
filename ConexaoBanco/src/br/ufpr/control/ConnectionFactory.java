/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.control;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
/**
 *
 * @author professor
 */
public class ConnectionFactory {

    private static final String SERVER = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "BANCAO"; //Schema name
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://"
            + SERVER + ":" + PORT + "/" + DATABASE;

    public static Connection createConnectionToMySQLConnection() throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) throws Exception {
            Connection con = createConnectionToMySQLConnection();
        if(con != null){
            System.out.println("Conexao efetuada com sucesso"+con);
            con.close();
        }
    }
    
}
