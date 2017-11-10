package br.com.trabalhosemestral.model;



public class Usuario {
    private int codigo;
    private String usu_email;
    private String usu_senha;

    public Usuario() {
    }

    public Usuario(int codigo, String usu_email, String usu_senha) {
        this.codigo = codigo;
        this.usu_email = usu_email;
        this.usu_senha = usu_senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }
}
