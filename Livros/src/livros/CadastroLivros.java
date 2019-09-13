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
public class CadastroLivros {

    public static void main(String[] args) {
        Livros livro1 = new Livros();
        Livros livro2 = new Livros();

        Autores autor1= new Autores();
        Autores autor2= new Autores();

        livro1.nome = "faucibus in ornare quam viverra";
        livro1.descricao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Purus sit amet luctus venenatis lectus magna fringilla.";
        livro1.valor=53.80;
        livro1.isbn="1234567899876";
        
        autor1.nomeAutor="malesuada fames";
        autor1.emailAutor="malesuada@lorem.com";
        autor1.cpfAutor="98756432112";
        
        livro2.nome = "adipiscing diam donec adipiscing tristique";
        livro2.descricao = "Diam ut venenatis tellus in metus vulputate eu scelerisque felis. Sapien eget mi proin sed libero. Nunc vel risus commodo viverra maecenas accumsan lacus vel facilisis. ";
        livro2.valor=82.30;
        livro2.isbn="1656437255463";

        autor2.nomeAutor="Ullamcorper Dignissim";
        autor2.emailAutor="dignissim@lorem.com";
        autor2.cpfAutor="65328745912";
        
        livro1.mostrarInformacoes();
        autor1.mostrarInformacoesAutor();
        livro2.mostrarInformacoes();
        autor2.mostrarInformacoesAutor();
    }
}