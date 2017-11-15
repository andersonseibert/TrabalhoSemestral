package br.com.trabalhosemestral.model;



public class Produto {
    private int id;
    private String nome_produto;
    private double quantidade_desejada;

    public Produto() {
    }

    public Produto(String nome_produto, double quantidade_desejada) {
        this.nome_produto = nome_produto;
        this.quantidade_desejada = quantidade_desejada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getQuantidade_desejada() {
        return quantidade_desejada;
    }

    public void setQuantidade_desejada(double quantidade_desejada) {
        this.quantidade_desejada = quantidade_desejada;
    }
}
