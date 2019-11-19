/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

import java.sql.Date;

/**
 *
 * @author Jonathan
 */
public class Aluno_VO {
    private String pk_grr;
    private String senha;
    private String nome;
    private String nomesocial;
    private Date datanascimento;
    private String sexo;
    private String cpf;
    /**
     * @return the pk_grr
     */
    public String getPk_grr() {
        return pk_grr;
    }

    /**
     * @param pk_grr the pk_grr to set
     */
    public void setPk_grr(String pk_grr) {
        this.pk_grr = pk_grr;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nomesocial
     */
    public String getNomesocial() {
        return nomesocial;
    }

    /**
     * @param nomesocial the nomesocial to set
     */
    public void setNomesocial(String nomesocial) {
        this.nomesocial = nomesocial;
    }

    /**
     * @return the datanascimento
     */
    public Date getDatanascimento() {
        return datanascimento;
    }

    /**
     * @param datanascimento the datanascimento to set
     */
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
