/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livros;

/**
 *
 * @author professor
 */
public class Livros {

    String nome, descricao, isbn;
    double valor;
    
    public void mostrarInformacoes(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Valor: "+this.valor);
        System.out.println("ISBN: "+this.isbn);
    }
}