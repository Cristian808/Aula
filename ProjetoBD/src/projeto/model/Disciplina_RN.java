/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import projetobd.Model.Conexao;

/**
 *
 * @author professor
 */
public class Disciplina_RN {
    Conexao conex;

       public Disciplina_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirDisciplina(Disciplina_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertDisciplina_sp(?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getIdDisciplina());
                     ps2.setString(2, obj.getNomeDisciplina());
                     ps2.setInt(3, obj.getPreRequisitos());
                     ps2.setString(4, obj.getFkCodCurso());
                     
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
       public boolean editarDepartamento(Disciplina_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateDisciplina_sp(?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getIdDisciplina());
                     ps2.setString(2, obj.getNomeDisciplina());
                     ps2.setInt(3, obj.getPreRequisitos());
                     ps2.setString(4, obj.getFkCodCurso());
                     
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
       public boolean excluirDepartamento(Disciplina_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeDisciplina_sp(?)}");
                     
                     ps2.setInt(1, obj.getIdDisciplina());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
}
