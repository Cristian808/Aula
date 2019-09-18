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

    private String nome, descricao, isbn;
    private double valor; 
    Autores autor= new Autores();

    public void mostrarInformacoes(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Valor: "+this.valor);
        System.out.println("ISBN: "+this.isbn);
        
        if(autor.verificaAutor(this.autor) == true){
            this.autor.mostrarInformacoesAutor();
        }else{
            System.out.println("Não há altores");
        }
        
    }

    public void ajustarValor(double reajuste){
        if(reajuste > 0.3){
            System.out.println("Reajuste nao permitido");
        }
        else{
            setValor(this.valor * reajuste);
        }
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}