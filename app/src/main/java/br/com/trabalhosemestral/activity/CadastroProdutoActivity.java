package br.com.trabalhosemestral.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ajm.prototipo.prototipotelas.R;
import br.com.trabalhosemestral.model.Produto;
import br.com.trabalhosemestral.model.Usuario;
import br.com.trabalhosemestral.service.ProdutoService;
import br.com.trabalhosemestral.service.UsuarioService;


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

//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        setContentView(R.layout.cadastro_produtos_layout);
//        final ListView listView = (ListView) findViewById(R.id.listv);
//
//        arrayList = new ArrayList<>();
//        adapter = new ArrayAdapter<String>(CadastroProdutoActivity.this, android.R.layout.simple_expandable_list_item_1, arrayList);
//        listView.setAdapter(adapter);
//        registerForContextMenu(listView);
//        editText9 = (EditText) findViewById(R.id.editText9);
//        editText11 = (EditText) findViewById(R.id.editText11);
//
//        Button btAdd = (Button) findViewById(R.id.button4);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (editText9.getText().length() == 0) {
//
//                    editText9.setError("Campo vazio");
//
//                } else if (editText11.getText().length() == 0) {
//
//                    editText11.setError("Campo vazio");
//
//                } else {
//
//                    String ingrediente = editText9.getText().toString();
//                    String quantidade = editText11.getText().toString();
//
//                    editText9.setText("");
//                    editText11.setText("");
//
//                    arrayList.add(ingrediente + " - " + quantidade);
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        });
//        registerForContextMenu(listView);
//
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listv) {
            menu.add("Remover");

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 0:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Atenção!");
                builder.setMessage("Deseja remover ?");
                builder.setCancelable(true);

                builder.setPositiveButton("Sim", null);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        arrayList.remove(info.position);
                        adapter.notifyDataSetChanged();
                    }
                })
                        .setNegativeButton("Cancelar", null)
                        .show();
//                AlertDialog dialog=builder.create();
//                dialog.show();
        }
        return true;
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
        tarefa.execute();
    }
}