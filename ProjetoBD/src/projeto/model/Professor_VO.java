/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.math.BigInteger;

/**
 *
 * @author professor
 */
public class Professor_VO {
    private int codProfessor;
    private String cpf;
    private String nome;
    private int cfe;

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCfe() {
        return cfe;
    }

    public void setCfe(int cfe) {
        this.cfe = cfe;
    }
    
}
