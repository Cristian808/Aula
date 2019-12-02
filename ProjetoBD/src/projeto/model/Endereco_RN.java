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
public class Endereco_RN {
    Conexao conex;

       public Endereco_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirEndereco(Endereco_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertEndereco_sp(?,?,?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getCep());
                     ps2.setString(2, obj.getBairro());
                     ps2.setInt(3, obj.getNumero());
                     ps2.setString(4, obj.getRua());
                     ps2.setString(5, obj.getFkAluno());
                     ps2.setString(6, obj.getComplemento());
                     
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
       public boolean editarEndereco(Endereco_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateEndereco_sp(?,?,?,?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getCep());
                     ps2.setString(2, obj.getBairro());
                     ps2.setInt(3, obj.getNumero());
                     ps2.setString(4, obj.getRua());
                     ps2.setString(5, obj.getFkAluno());
                     ps2.setString(6, obj.getComplemento());
                     ps2.setInt(7, obj.getIdEndereco());
                     
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
       public boolean excluirEndereco(Endereco_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeEndereco_sp(?)}");
                     
                     ps2.setInt(1, obj.getIdEndereco());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
       
       public boolean getEndereco(Endereco_VO obj) throws Exception
       {
            try
            {
                conex = new Conexao();
                Statement stm = conex.conectar().createStatement();
                ResultSet rs = stm.executeQuery("select * from [BDGrupo2].[dbo].[UNI_Endereco] where Id_Endereco = " + obj.getIdEndereco());
                
                while (rs.next())
                     {
                        obj.setBairro(rs.getString("BAIRRO"));
                        obj.setCep(rs.getInt("CEP"));
                        obj.setComplemento(rs.getString("COMPLEMENTO"));
                        obj.setFkAluno(rs.getString("FK_ALUNO"));
                        obj.setNumero(rs.getInt("NUMERO"));
                        obj.setRua(rs.getString("RUA"));
                                   
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
