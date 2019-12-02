/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projetobd.Model.Conexao;

/**
 *
 * @author professor
 */
public class Departamento_RN {
    Conexao conex;

       public Departamento_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirDepartamento(Departamento_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertDepartamento_sp(?,?)}");
                     
                     ps2.setInt(1, obj.getIdDepartamento());
                     ps2.setString(2, obj.getNomeDepartamento());
                     
                     ps2.executeUpdate();
                     return true;
              }
              catch (SQLException e)
              {
                     throw new Exception("Falha ao cadastrar Gerente:\n"+ e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//EDITAR------------------------------------------------------------------------
       public boolean editarDepartamento(Departamento_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateDepartamento_sp(?,?)}");
                     
                     ps2.setInt(1, obj.getIdDepartamento());
                     ps2.setString(2, obj.getNomeDepartamento());
                     
                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//EXCLUIR------------------------------------------------------------------------
       public boolean excluirDepartamento(Departamento_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeDeparamento_sp(?)}");
                     
                     ps2.setInt(1, obj.getIdDepartamento());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
       
       public boolean getDepartamento(Departamento_VO obj) throws Exception
       {
            try
            {
                conex = new Conexao();
                Statement stm = conex.conectar().createStatement();
                ResultSet rs = stm.executeQuery("select * from [BDGrupo2].[dbo].[UNI_Departamento] where ID_DEPARTAMENTO = " + obj.getIdDepartamento());
                
                while (rs.next())
                     {
                        obj.setNomeDepartamento(rs.getString("NOME_DEPARTAMENTO"));
                                   
                        return true;
                     }
                    
                return true;
                            
            }
            catch (Exception e)
            {
                throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
            }
       }
}
