package br.com.trabalhosemestral.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ajm.prototipo.prototipotelas.R;
import br.com.trabalhosemestral.model.Produto;
import br.com.trabalhosemestral.service.ProdutoService;


public class CadastroProdutoActivity extends Activity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    private EditText editText9;
    private EditText editText11;
    private EditText edtNomeProduto;
    private EditText edtDescricaoProduto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produtos_layout);
        edtNomeProduto = (EditText) findViewById(R.id.editText6);
        edtDescricaoProduto = (EditText) findViewById(R.id.editText7);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listv) {
            menu.add("Remover");

        }
    }
    public void Cancelar(View view) {
        finish();
    }

    public void InserirProduto(View view) {


        if (edtDescricaoProduto.getText().length() == 0) {
            edtDescricaoProduto.setError("Campo vazio");
            return;
        }
        if (edtNomeProduto.getText().length() == 0) {
            edtNomeProduto.setError("Campo vazio");
            return;
        }

        final String nomeProduto = edtNomeProduto.getText().toString();
        final String descricaoProduto = edtDescricaoProduto.getText().toString();
        final ProdutoService service = new ProdutoService();

        AsyncTask<String, Object, String> tarefa =

                new AsyncTask<String, Object, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        Produto produto = new Produto(descricaoProduto, nomeProduto, 0);
                        service.Inserir(produto);
                        return "OK";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        if (s.equals("OK")) {

                            Toast.makeText(getBaseContext(), "Produto Cadastrado com Sucesso.", Toast.LENGTH_LONG).show();

                            /*LIMPAR CAMPOS*/
                            edtNomeProduto.setText("");
                            edtDescricaoProduto.setText("");
                        }

                    }
                };
        finish();
        tarefa.execute();
    }
}