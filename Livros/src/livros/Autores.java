package livros;

public class Autores {
    private String nomeAutor,emailAutor,cpfAutor;
    
    public void mostrarInformacoesAutor(){
    	System.out.println("Nome do autor: " +this.nomeAutor);
        System.out.println("Email do autor: " +this.emailAutor);
        System.out.println("CPF do autor: " +this.cpfAutor);
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public void setEmailAutor(String emailAutor) {
        this.emailAutor = emailAutor;
    }

    public String getCpfAutor() {
        return cpfAutor;
    }

    public void setCpfAutor(String cpfAutor) {
        this.cpfAutor = cpfAutor;
    }
}