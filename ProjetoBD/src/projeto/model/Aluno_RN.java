/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.sql.*;
import projetobd.Model.Conexao;

/**
 *
 * @author professor
 */
public class Aluno_RN {
    
    Conexao conex;

       public Aluno_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirAluno(Aluno_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertAluno_sp(?,?,?,?,?)}");
                     
                     ps2.setString (1, obj.getMatricula());
                     ps2.setString(2, obj.getNome());
                     ps2.setString(3, obj.getTipoAdmissao());
                     ps2.setInt(4, obj.getFkTurma());
                     ps2.setInt(5, obj.getFkHistorico());
                     
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
       public boolean editarAluno(Aluno_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateAluno_sp(?,?,?,?,?)}");
                     
                     ps2.setString (1, obj.getMatricula());
                     ps2.setString(2, obj.getNome());
                     ps2.setString(3, obj.getTipoAdmissao());
                     ps2.setInt(4, obj.getFkTurma());
                     ps2.setInt(5, obj.getFkHistorico());
                     
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
       public boolean excluirAluno(Aluno_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeAluno_sp(?)}");
                     
                     ps2.setString (1, obj.getMatricula());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//LOGINS------------------------------------------------------------------------
      public boolean getAluno(Aluno_VO obj) throws Exception
       {
            try
            {
                conex = new Conexao();
                Statement stm = conex.conectar().createStatement();
                ResultSet rs = stm.executeQuery("select * from [BDGrupo2].[dbo].[UNI_Aluno] where MATRICULA = " + obj.getMatricula());
                
                while (rs.next())
                     {
                        obj.setFkHistorico(rs.getInt("FK_HISTORICO"));
                        obj.setFkTurma(rs.getInt("FK_TURMA"));
                        obj.setNome(rs.getString("NOME"));
                        obj.setTipoAdmissao(rs.getString("TIPO_ADMISSAO"));
                                   
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
