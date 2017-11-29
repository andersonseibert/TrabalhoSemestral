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


public class LoginActivity extends Activity {

    EditText edtLogin;
    EditText edtSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }

    public void FazerLogin(final View view) {


        final String login = edtLogin.getText().toString();
        final String senha = edtSenha.getText().toString();

        final UsuarioService service = new UsuarioService();
        AsyncTask<String, Object, String> tarefa =

                new AsyncTask<String, Object, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        Usuario usuario = new Usuario(login, senha, null);
                        service.processLogin(usuario);
                        return "OK";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        boolean re = service.EfetuarLogin();
                        if (re) {
                            AbrirMenuPrincipal(view);
                        } else {
                            Toast.makeText(getBaseContext(), "Login ou Senha Incorreto", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                };
        tarefa.execute();
    }

    public void AbrirMenuPrincipal(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void AbrirCadastroUsuario(View view) {
        Intent intent2 = new Intent(getApplicationContext(), CadastroUsuarioActivity.class);
        startActivity(intent2);
    }
}
