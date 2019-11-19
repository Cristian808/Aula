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
public class Curso_VO {
    private String codCurso;
    private int fkDepartamento;
    private int creditosConclusao;
    private String nomeCurso;
    private int duracao;

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public int getFkDepartamento() {
        return fkDepartamento;
    }

    public void setFkDepartamento(int fkDepartamento) {
        this.fkDepartamento = fkDepartamento;
    }

    public int getCreditosConclusao() {
        return creditosConclusao;
    }

    public void setCreditosConclusao(int creditosConclusao) {
        this.creditosConclusao = creditosConclusao;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
