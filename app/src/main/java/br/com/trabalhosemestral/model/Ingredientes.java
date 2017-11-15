package br.com.trabalhosemestral.model;



public class Ingredientes {
    private int id;
    private String nome_ingrediente;
    private Double quantidade_ingrediente_por_unidade;

    public Ingredientes(String nome_ingrediente, Double quantidade_ingrediente_por_unidade) {
        this.nome_ingrediente = nome_ingrediente;
        this.quantidade_ingrediente_por_unidade = quantidade_ingrediente_por_unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public Double getQuantidade_ingrediente_por_unidade() {
        return quantidade_ingrediente_por_unidade;
    }

    public void setQuantidade_ingrediente_por_unidade(Double quantidade_ingrediente_por_unidade) {
        this.quantidade_ingrediente_por_unidade = quantidade_ingrediente_por_unidade;
    }
}
