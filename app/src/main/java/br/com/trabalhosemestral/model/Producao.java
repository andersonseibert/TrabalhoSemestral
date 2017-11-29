package br.com.trabalhosemestral.model;


import java.util.Date;

public class Producao {

    private int id;
    private int ordem_producao;
    private int quantidade;
    private Date data_criacao;
    private int produto_cod;
    private int ingrediente_cod;

    public Producao() {
    }

    public Producao(int ordem_producao, int quantidade, Date data_criacao, int produto_cod, int ingrediente_cod) {
        this.ordem_producao = ordem_producao;
        this.quantidade = quantidade;
        this.data_criacao = data_criacao;
        this.produto_cod = produto_cod;
        this.ingrediente_cod = ingrediente_cod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdem_producao() {
        return ordem_producao;
    }

    public void setOrdem_producao(int ordem_producao) {
        this.ordem_producao = ordem_producao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int protocolo) {
        this.quantidade = protocolo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public int getProduto_cod() {
        return produto_cod;
    }

    public void setProduto_cod(int produto_cod) {
        this.produto_cod = produto_cod;
    }

    public int getIngrediente_cod() {
        return ingrediente_cod;
    }

    public void setIngrediente_cod(int ingrediente_cod) {
        this.ingrediente_cod = ingrediente_cod;
    }
}
