package br.com.trabalhosemestral.model;



public class Usuario {


    private String email;
    private String senha;
    private String nome;



    public Usuario(String usu_email, String usu_senha, String nome) {
        this.email = usu_email;
        this.senha = usu_senha;
        this.nome = nome;
    }

    public String getUsu_email() {
        return email;
    }

    public void setUsu_email(String usu_email) {
        this.email = usu_email;
    }

    public String getUsu_senha() {
        return senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.senha = usu_senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario() {
    }
}
