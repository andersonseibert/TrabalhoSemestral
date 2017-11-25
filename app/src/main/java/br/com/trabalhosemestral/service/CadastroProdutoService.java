package br.com.trabalhosemestral.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalhosemestral.model.Produto;

public class CadastroProdutoService {
    RESTUtil restUtil = new RESTUtil();
    private String httpResult;
    private String JSON_URI = "http://10.0.2.2:80/mydrink/api/produto";


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

    public List<Produto> ListarTodos() {
        List<Produto> produtosList = new ArrayList<>();
        this.httpResult = restUtil.processRequest(JSON_URI, "GET", "");
        if (this.httpResult != null) {
            try {
                JSONArray usuarios = new JSONArray(this.httpResult);

                for (int i = 0; i < usuarios.length(); i++) {
                    JSONObject produto = usuarios.getJSONObject(i);
                    Produto u = new Produto();
                    u.setNome_produto(produto.getString("nome_produto"));
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
