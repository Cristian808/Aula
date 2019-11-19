/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.sql.Date;

/**
 *
 * @author professor
 */
public class HistoricoEscolar_VO {
    private int nota;
    private Date dataCursada;
    private String disciplinas;
    private int idHistorico;

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getDataCursada() {
        return dataCursada;
    }

    public void setDataCursada(Date dataCursada) {
        this.dataCursada = dataCursada;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
