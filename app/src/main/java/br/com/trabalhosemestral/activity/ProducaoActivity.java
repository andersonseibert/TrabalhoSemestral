package br.com.trabalhosemestral.activity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.ajm.prototipo.prototipotelas.R;
import br.com.trabalhosemestral.model.Produto;
import br.com.trabalhosemestral.service.ProdutoService;

/**
 * Created by rossi on 15/11/2017.
 */

public class ProducaoActivity extends AppCompatActivity {


    private ListView lvRegistros;
    ArrayAdapter<String> adaptador;
    final List<String> produtosDaLista = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producao_layout);
        lvRegistros = (ListView) findViewById(R.id.listv_produzir);
        lvRegistros.setLongClickable(true);

        ListarProdutos();
        AbrirOpcoes();
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        if (v.getId() == R.id.listv_Cadastrados) {
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//            builder.setTitle("Desejas Produzir este Item?");
//            builder.setMessage("Informe a quantidade a ser produzida!");
//            builder.getContext();
//
//            builder.setPositiveButton("Produzir", null);
//            builder.setPositiveButton("Produzir", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//
//                    adapter.notifyDataSetChanged();
//                }
//            })
//                    .setNegativeButton("Cancelar", null)
//                    .show();
//        }
//    }


    public void Sair(View view) {

        finish();
    }

    public void ListarProdutos() {
        final ProdutoService service = new ProdutoService();
        AsyncTask<String, Object, String> tarefa =
                new AsyncTask<String, Object, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        service.FazerRequisicaoListarTodos();
                        return "OK";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        List<Produto> produtos = service.ListarTodos();
                        for (Produto p : produtos) {
                            produtosDaLista.add(p.getId() + "-" + p.getNome_produto());
                        }
                        adaptador = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, produtosDaLista);
                        lvRegistros.setAdapter(adaptador);
                    }
                };
        tarefa.execute();
    }

    public void AbrirOpcoes() {
        lvRegistros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int posicao, long id) {
                MostrarDialogo(posicao);
                return false;
            }
        });
    }

    public void Produzir() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Desejas Produzir este Item?");
        builder.setMessage("Informe a quantidade a ser produzida!");

        final EditText campoDeTextoNoDialogo = new EditText(this);
        campoDeTextoNoDialogo.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(campoDeTextoNoDialogo);


        builder.setPositiveButton("Produzir", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String QuantidadeAProduzir = campoDeTextoNoDialogo.getText().toString();
                dialog.dismiss();
            }
        });

        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    public void MostrarDialogo(final int posicaoItemLista) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Opções");
        builder.setMessage("O que deseja Fazer?");

        builder.setNeutralButton("Produzir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //contatos.remove(posicaoRemover);
                ///ListarItens();


                dialog.dismiss();
                Produzir();
            }
        });

        android.app.AlertDialog alert = builder.create();
        alert.show();
    }
}
