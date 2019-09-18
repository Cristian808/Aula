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

        livro1.setNome("faucibus in ornare quam viverra");
        livro1.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Purus sit amet luctus venenatis lectus magna fringilla.");
        livro1.setValor(53.80);
        livro1.setIsbn("1234567899876");
        livro1.autor.setNomeAutor("malesuada fames");
        livro1.autor.setEmailAutor("malesuada@lorem.com");
        livro1.autor.setCpfAutor("98756432112");
        
        
        livro2.setNome("adipiscing diam donec adipiscing tristique");
        livro2.setDescricao("Diam ut venenatis tellus in metus vulputate eu scelerisque felis. Sapien eget mi proin sed libero. Nunc vel risus commodo viverra maecenas accumsan lacus vel facilisis. ");
        livro2.setValor(82.30);
        livro2.setIsbn("1656437255463");
        livro2.autor.setNomeAutor("Ullamcorper Dignissim");
        livro2.autor.setEmailAutor("dignissim@lorem.com");
        livro2.autor.setCpfAutor("65328745912");
        
        livro1.mostrarInformacoes();
        livro2.mostrarInformacoes();
    }
}