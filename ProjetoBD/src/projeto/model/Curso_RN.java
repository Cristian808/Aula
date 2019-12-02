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
public class Curso_RN {
    Conexao conex;

       public Curso_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirCurso(Curso_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertCurso_sp(?,?,?,?,?)}");
                     
                     ps2.setString (1, obj.getCodCurso());
                     ps2.setInt(2, obj.getFkDepartamento());
                     ps2.setInt(3, obj.getCreditosConclusao());
                     ps2.setString(4, obj.getNomeCurso());
                     ps2.setInt(5, obj.getDuracao());
                     
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
       public boolean editarCurso(Curso_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateCurso_sp(?,?,?,?,?)}");
                     
                     ps2.setString (1, obj.getCodCurso());
                     ps2.setInt(2, obj.getFkDepartamento());
                     ps2.setInt(3, obj.getCreditosConclusao());
                     ps2.setString(4, obj.getNomeCurso());
                     ps2.setInt(5, obj.getDuracao());
                     
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
       public boolean excluirCurso(Curso_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeCurso_sp(?)}");
                     
                     ps2.setString (1, obj.getCodCurso());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
       
       public boolean getCurso(Curso_VO obj) throws Exception
       {
            try
            {
                conex = new Conexao();
                Statement stm = conex.conectar().createStatement();
                ResultSet rs = stm.executeQuery("select * from [BDGrupo2].[dbo].[UNI_CURSO] where COD_CURSO = " + obj.getCodCurso());
                
                while (rs.next())
                     {
                        obj.setCreditosConclusao(rs.getInt("CREDITOS_CONCLUSAO"));
                        obj.setDuracao(rs.getInt("DURACAO"));
                        obj.setFkDepartamento(rs.getInt("FK_DEPARTAMENTO"));
                        obj.setNomeCurso(rs.getString("NOME_CURSO"));
                                   
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
