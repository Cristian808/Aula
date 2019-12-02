
package projetobd.Model;

import java.sql.*;

/**
 *
 * @author Jonathan
 */
public class Conexao {
    
       Connection con = null;
       public Connection conectar()
       {//URL do Banco de Dados	jdbc:sqlserver://201.30.92.194\BDGrupo2:1433;databaseName=BDGrupo2
              try
              {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                     con = DriverManager.getConnection("jdbc:sqlserver://201.30.92.194\\BDUniversidade:1433;databaseName=BDUniversidade","sbd","sbd01");;
//                     con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:/SADGR/diretor/basedados/CRAM.FDB", "sysdba", "masterkey");
                        con = DriverManager.getConnection("jdbc:sqlserver://201.30.92.194\\BDGrupo2:1433;databaseName=BDGrupo2", "sbdgrupo2", "log22**11");    
              }
              catch (ClassNotFoundException e)
              {
                     System.out.println("Nao conectou: " + e.getMessage());
              }
              catch (SQLException e)
              {
                     System.out.println("Erro Sql: " + e.getMessage());
              }
              return con;
       }   
           
     public boolean disconect() {  
     try {  
       con.close();
       return true;
     }  
     catch(SQLException e) {  
       e.getMessage();  
       return false;  
     }  
   }
}
