
package br.com.trabalhosemestral.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalhosemestral.model.Global;
import br.com.trabalhosemestral.model.Ingredientes;

public class IngredienteService {
    RESTUtil restUtil = new RESTUtil();
    private String httpResult;
    private String JSON_URI = Global.caminho_api + "ingredientes";

    public void Inserir(Ingredientes ingre) {
        JSONObject object = new JSONObject();
        try {
            object.put("nome_ingrediente", ingre.getNome_ingrediente());
            object.put("quantidade_ingrediente_por_unidade", ingre.getQuantidade_ingrediente_por_unidade());            
            httpResult = restUtil.processRequest(JSON_URI, "POST", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Alterar(Ingredientes ingre) {
        JSONObject object = new JSONObject();
        try {
            object.put("nome_ingrediente", ingre.getNome_ingrediente());
            object.put("quantidade_ingrediente_por_unidade", ingre.getQuantidade_ingrediente_por_unidade());                        
            httpResult = restUtil.processRequest(JSON_URI, "PUT", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Excluir(Ingredientes ingre) {

        JSONObject object = new JSONObject();
        try {
            object.put("nome_ingrediente", ingre.getNome_ingrediente());
            object.put("quantidade_ingrediente_por_unidade", ingre.getQuantidade_ingrediente_por_unidade());
            httpResult = restUtil.processRequest(JSON_URI, "DELETE", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void Buscar(int codigoProduto) {

    }

    public void FazerRequisicaoListarTodos() {
        this.httpResult = restUtil.processRequest(JSON_URI, "GET", "");
    }

    public List<Ingredientes> ListarTodos() {
        List<Ingredientes> produtosList = new ArrayList<>();
        if (this.httpResult != null) {
            try {
                JSONArray produtosRetorno = new JSONArray(this.httpResult);
                for (int i = 0; i < produtosRetorno.length(); i++) {
                    JSONObject produto = produtosRetorno.getJSONObject(i);
                    Ingredientes u = new Ingredientes();
                    u.setId(produto.getInt("id"));
                    u.setNome_ingrediente(produto.getString("nome_ingrediente"));
                    u.setQuantidade_ingrediente_por_unidade(produto.getDouble("quantidade_ingrediente_por_unidade"));
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
