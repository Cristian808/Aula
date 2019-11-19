/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

/**
 *
 * @author professor
 */
public class Disciplina_VO {
    private int idDisciplina;
    private String nomeDisciplina;
    private int preRequisitos;
    private String fkCodCurso;

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(int preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getFkCodCurso() {
        return fkCodCurso;
    }

    public void setFkCodCurso(String fkCodCurso) {
        this.fkCodCurso = fkCodCurso;
    }
}
