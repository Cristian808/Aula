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
public class Turma_VO {
    private int fkDisciplina;
    private int fkProfessor;
    private int idTurma;

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getFkDisciplina() {
        return fkDisciplina;
    }

    public void setFkDisciplina(int fkDisciplina) {
        this.fkDisciplina = fkDisciplina;
    }

    public int getFkProfessor() {
        return fkProfessor;
    }

    public void setFkProfessor(int fkProfessor) {
        this.fkProfessor = fkProfessor;
    }
}
