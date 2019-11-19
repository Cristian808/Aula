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
public class Aluno_VO {
    private String matricula;
    private String nome;
    private String tipoAdmissao;
    private int fkTurma;
    private int fkHistorico;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoAdmissao() {
        return tipoAdmissao;
    }

    public void setTipoAdmissao(String tipoAdmissao) {
        this.tipoAdmissao = tipoAdmissao;
    }

    public int getFkTurma() {
        return fkTurma;
    }

    public void setFkTurma(int fkTurma) {
        this.fkTurma = fkTurma;
    }

    public int getFkHistorico() {
        return fkHistorico;
    }

    public void setFkHistorico(int fkHistorico) {
        this.fkHistorico = fkHistorico;
    }
    
}
