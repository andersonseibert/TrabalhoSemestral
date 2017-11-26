package br.com.trabalhosemestral.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalhosemestral.model.Global;
import br.com.trabalhosemestral.model.Produto;

public class ProdutoService {
    RESTUtil restUtil = new RESTUtil();
    private String httpResult;
    private String JSON_URI = Global.caminho_api + "produto";


    public void Inserir(Produto produto) {
        JSONObject object = new JSONObject();
        try {
            object.put("nome_produto", produto.getNome_produto());
            object.put("quantidade_desejada", produto.getQuantidade_desejada());
            httpResult = restUtil.processRequest(JSON_URI, "POST", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Alterar(Produto produto) {
        JSONObject object = new JSONObject();
        try {
            object.put("nome_produto", produto.getNome_produto());
            object.put("quantidade_desejada", produto.getQuantidade_desejada());
            httpResult = restUtil.processRequest(JSON_URI, "PUT", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Excluir(int codigoProduto) {

    }

    public void Buscar(int codigoProduto) {

    }

    public void FazerRequisicaoListarTodos() {
        this.httpResult = restUtil.processRequest(JSON_URI, "GET", "");
    }

    public List<Produto> ListarTodos() {
        List<Produto> produtosList = new ArrayList<>();
        if (this.httpResult != null) {
            try {
                JSONArray produtosRetorno = new JSONArray(this.httpResult);
                for (int i = 0; i < produtosRetorno.length(); i++) {
                    JSONObject produto = produtosRetorno.getJSONObject(i);
                    Produto u = new Produto();
                    u.setId(produto.getInt("id"));
                    u.setNome_produto(produto.getString("nome_produto"));
                    u.setQuantidade_desejada(produto.getDouble("quantidade_desejada"));
                    produtosList.add(u);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.httpResult = null;
        }
        return produtosList;
    }
}
