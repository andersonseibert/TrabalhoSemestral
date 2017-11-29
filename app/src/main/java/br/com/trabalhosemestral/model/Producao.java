package br.com.trabalhosemestral.model;


import java.util.Date;

public class Producao {

    private int id;
    private int ordem_producao;
    private int protocolo;
    private Date data_criacao;
    private Produto produto_cod;
    private Ingredientes ingrediente_cod;

    public Producao() {
    }

    public Producao(int ordem_producao, int protocolo, Date data_criacao, Produto produto_cod, Ingredientes ingrediente_cod) {
        this.ordem_producao = ordem_producao;
        this.protocolo = protocolo;
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

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Produto getProduto_cod() {
        return produto_cod;
    }

    public void setProduto_cod(Produto produto_cod) {
        this.produto_cod = produto_cod;
    }

    public Ingredientes getIngrediente_cod() {
        return ingrediente_cod;
    }

    public void setIngrediente_cod(Ingredientes ingrediente_cod) {
        this.ingrediente_cod = ingrediente_cod;
    }
}
