package br.com.trabalhosemestral.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ajm.prototipo.prototipotelas.R;
import br.com.trabalhosemestral.model.Usuario;
import br.com.trabalhosemestral.service.UsuarioService;

/**
 * Created by Anderson on 29/09/2017.
 */

public class CadastroUsuarioActivity extends Activity {

    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    EditText edtpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrousuario_layout);


        edtNome = (EditText) findViewById(R.id.editText10);
        edtEmail = (EditText) findViewById(R.id.editText12);
        edtSenha = (EditText) findViewById(R.id.editText13);
        edtpass = (EditText) findViewById(R.id.edtpass);
    }

    public void VoltarTelaLogin(View view) {

        finish();
    }

    public void button(View view) {
        Intent intent = new Intent(getBaseContext(), CadastroProdutoActivity.class);
        startActivity(intent);
    }

    public void CadastrarUsuario(View view) {


        if (edtNome.getText().length() == 0) {
            edtNome.setError("Campo vazio");
            return;
        }
        if (edtEmail.getText().length() == 0) {
            edtEmail.setError("Campo vazio");
            return;
        }
        if (edtSenha.getText().length() == 0) {
            edtSenha.setError("Campo vazio");
            return;
        }

        final String nome = edtNome.getText().toString();
        final String login = edtEmail.getText().toString();
        final String senha = edtSenha.getText().toString();
        final UsuarioService service = new UsuarioService();

        AsyncTask<String, Object, String> tarefa =
                new AsyncTask<String, Object, String>() {
                    @Override
                    protected String doInBackground(String... params) {

                        Usuario usuario = new Usuario(login, senha, nome);
                        service.InserirUsuario(usuario);
                        return "OK";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        if (s.equals("OK")) {
                            edtNome.setText("");
                            edtEmail.setText("");
                            edtSenha.setText("");
                            edtpass.setText("");
                            Intent i = new Intent(getBaseContext(), LoginActivity.class);
                            startActivity(i);
                            Toast.makeText(getBaseContext(), "Usuario Cadastrado com Sucesso.", Toast.LENGTH_LONG).show();

                        }

                    }
                };
        tarefa.execute();
    }
    public static class TrazerUsuario {

        private static TrazerUsuario instance = null;
        private static Usuario usuario = null;

        public static TrazerUsuario getInstance() {
            if (instance == null) {
                usuario = new Usuario();
                return instance = new TrazerUsuario();
            } else {
                return instance;
            }
        }

        public void setUsuario(Usuario usuario) {
            TrazerUsuario.usuario = usuario;
        }

        public Usuario getUsuario() {
            return TrazerUsuario.usuario;
        }
    }
}
