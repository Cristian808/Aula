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
public class HistoricoEscolar_RN {
    Conexao conex;

       public HistoricoEscolar_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirEndereco(HistoricoEscolar_VO obj)throws Exception
       {
              //CADASTRAR O FORNECEDOR DE RECURSOS     
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.insertHistorico_Escolar_sp(?,?,?)}");
                     
                     ps2.setInt(1, obj.getNota());
                     ps2.setDate(2, obj.getDataCursada());
                     ps2.setString(3, obj.getDisciplinas());
                     
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
       public boolean editarEndereco(HistoricoEscolar_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.updateHistorico_Escolar_sp(?,?,?,?)}");
                     
                     ps2.setInt(1, obj.getNota());
                     ps2.setDate(2, obj.getDataCursada());
                     ps2.setString(3, obj.getDisciplinas());
                     ps2.setInt(4, obj.getIdHistorico());
                     
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
       public boolean excluirEndereco(HistoricoEscolar_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.removeHistorico_Escolar_sp(?)}");
                     
                     ps2.setInt(1, obj.getIdHistorico());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
}
