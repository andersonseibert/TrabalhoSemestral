package br.com.trabalhosemestral.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalhosemestral.model.Global;
import br.com.trabalhosemestral.model.Producao;


public class ProducaoService {
    RESTUtil restUtil = new RESTUtil();
    private String httpResult;
    private String JSON_URI = Global.caminho_api + "producao";

    public void Inserir(Producao producao) {

        JSONObject object = new JSONObject();
        try {
            object.put("ordem_producao", producao.getProduto_cod());
            object.put("produto_cod", producao.getProduto_cod());
            object.put("quantidade", producao.getQuantidade());
            object.put("data_criacao", "");

            httpResult = restUtil.processRequest(JSON_URI, "POST", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void Alterar(Producao producao) {

    }

    public void Excluir(int codigoProducao) {

    }

    public void Buscar(int codigoProducao) {

    }

    public void FazerRequisicaoListarTodos() {
        this.httpResult = restUtil.processRequest(JSON_URI, "GET", "");
    }

    public List<Producao> ListarTodos() {
        List<Producao> list = new ArrayList<>();
        if (this.httpResult != null) {
            try {
                JSONArray Retorno = new JSONArray(this.httpResult);
                for (int i = 0; i < Retorno.length(); i++) {
                    JSONObject producao = Retorno.getJSONObject(i);
                    Producao u = new Producao();
                    u.setId(producao.getInt("id"));
                    u.setOrdem_producao(producao.getInt("ordem_producao"));
                    list.add(u);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.httpResult = null;
        }
        return list;
    }
}
