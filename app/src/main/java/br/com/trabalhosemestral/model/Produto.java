package br.com.trabalhosemestral.model;


public class Produto {
    private int id;
    private String nome_produto;
    private String descricao_produto;
    private double quantidade_desejada;

    public Produto() {
    }

    public Produto(String descricao_produto, String nome_produto, double quantidade_desejada) {
        this.descricao_produto = descricao_produto;
        this.nome_produto = nome_produto;
        this.quantidade_desejada = quantidade_desejada;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
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
