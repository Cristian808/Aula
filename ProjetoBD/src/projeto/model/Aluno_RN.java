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
//       public boolean logar(Aluno_VO obj) throws Exception
//       {
//              Aluno_VO alunoVO = obj;
//              try
//              {
//                     conex = new Conexao();
//                     Statement stm = conex.conectar().createStatement();
//
//                     ResultSet rs = stm.executeQuery("Select * from Aluno where PK_GRR = " + "'" + alunoVO.getPk_grr() + "'");
//                     while (rs.next())
//                     {
//                            if (alunoVO.getSenha().equals(rs.getString("SENHA")))
//                            {
//                                   alunoVO.setNome(rs.getString("NOME"));
//                                   alunoVO.setNomesocial(rs.getString("NOMESOCIAL"));
//                                   alunoVO.setCpf(rs.getString("CPF"));
//                                   alunoVO.setDatanascimento(rs.getDate("DATANASCIMENTO"));
//                                   alunoVO.setSexo(rs.getString("SEXO"));
//                                   alunoVO.setSenha(rs.getString("SENHA"));
//                                   
//                                   return true;
//                            }
//                            throw new Exception("Senha incorreta");
//                     }
//              }
//              catch (SQLException e)
//              {
//                     throw new Exception("Falha no login do Gerente:\n"+e.getMessage());
//              }
//              return false;
//       }
//       
}
