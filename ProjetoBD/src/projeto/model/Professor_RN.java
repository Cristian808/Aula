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
public class Professor_RN {
    Conexao conex;

       public Professor_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirProfessor(Professor_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertProfessor_sp(?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getCodProfessor());
                     ps2.setInt(2, Integer.parseInt(obj.getCpf()));
                     ps2.setString(3, obj.getNome());
                     ps2.setInt(4, obj.getCfe());
                     
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
       public boolean editarProfessor(Professor_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateProfessor_sp(?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getCodProfessor());
                     ps2.setInt(2, Integer.parseInt(obj.getCpf()));
                     ps2.setString(3, obj.getNome());
                     ps2.setInt(4, obj.getCfe());
                     
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
       public boolean excluirProfessor(Professor_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeProfessor_sp(?)}");
                     
                     ps2.setInt(1, obj.getCodProfessor());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
       
       
       public boolean getProfessor(Professor_VO obj) throws Exception
       {
            try
            {
                conex = new Conexao();
                Statement stm = conex.conectar().createStatement();
                ResultSet rs = stm.executeQuery("select * from [BDGrupo2].[dbo].[UNI_Professor] where COD_PROFESSOR = " + obj.getCodProfessor());
                
                while (rs.next())
                     {
                        obj.setCfe(rs.getInt("CFE"));
                        obj.setCpf(Integer.toString(rs.getInt("CPF")));
                        obj.setNome(rs.getString("NOME"));
                                   
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
