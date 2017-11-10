package br.com.trabalhosemestral.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalhosemestral.model.Usuario;

public class UsuarioService {

    RESTUtil restUtil = new RESTUtil();


    private String httpResult;

    private String JSON_URI ="http://10.0.2.2:80/0800mobile/api/usuario";

    public void save(Usuario usuario) {
        JSONObject object = new JSONObject();

        try {

            object.put("codigo", usuario.getCodigo() );
            object.put("email", usuario.getUsu_email() );

            httpResult = restUtil.processRequest(JSON_URI, "POST", object.toString() );

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void processGet() {
        this.httpResult = restUtil.processRequest(JSON_URI, "GET", "");
    }

    public List<Usuario> findAll() {
        List<Usuario> usuariosList = new ArrayList<>();

        if (this.httpResult != null) {
            try {
                JSONArray usuarios = new JSONArray(this.httpResult);

                for (int i = 0; i < usuarios.length(); i++) {
                    JSONObject usuario = usuarios.getJSONObject(i);
                    Usuario u = new Usuario();
                    u.setUsu_email(usuario.getString("email"));
                    usuariosList.add(u);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.httpResult = null;
        }
        return usuariosList;
    }

}
