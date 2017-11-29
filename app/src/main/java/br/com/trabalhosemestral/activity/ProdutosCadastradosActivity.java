package br.com.trabalhosemestral.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class ProdutosCadastradosActivity extends Activity {

    private ListView lvRegistros;
    ArrayAdapter<String> adaptador;
    final List<String> produtosDaLista = new ArrayList<String>();
    private EditText edtNomeProduto;
    private EditText edtDescricaoProduto;
    private Produto produto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produtos_cadastrados_layout);

        lvRegistros = (ListView) findViewById(R.id.listv_Cadastrados);
        lvRegistros.setLongClickable(true);


//        final List<String> produtosDaLista = new ArrayList<String>();
//        produtosDaLista.add("1-Teste");
//
//        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtosDaLista);
//        lvRegistros.setAdapter(adaptador);
        //adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtosDaLista);
        /*CRUD*/

        ListarProdutos();
        AbrirOpcoes();
    }

    public void AbreCadastroProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), CadastroProdutoActivity.class);
        startActivity(intent);
    }

    public void Voltar(View view) {
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

    public void EditarItem(int posicao) {

    }

    public void ExcluirItem(int posicao) {
        String[] registro = produtosDaLista.get(posicao).split("-");
        int idProduto = Integer.parseInt(registro[0]);

        final ProdutoService service = new ProdutoService();
        AsyncTask<String, Object, String> tarefa =
                new AsyncTask<String, Object, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        service.Excluir(produto);
                        return "OK";
                    }

                };
        tarefa.execute();
    }


    public void Produzir() {

    }

    public void AbrirOpcoes() {
        lvRegistros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int posicao, long id) {
                MostrarDialogo(posicao);
                return false;
            }
        });
    }


    public void MostrarDialogo(final int posicaoItemLista) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opções");
        builder.setMessage("O que deseja Fazer?");

        builder.setNeutralButton("Produzir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //contatos.remove(posicaoRemover);
                ///ListarItens();
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //contatos.remove(posicaoRemover);
                ///ListarItens();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                ExcluirItem(posicaoItemLista);
                produtosDaLista.remove(posicaoItemLista);
                adaptador.notifyDataSetChanged();

                dialog.dismiss();

            }

        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
