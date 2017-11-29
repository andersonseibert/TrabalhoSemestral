package br.com.trabalhosemestral.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.ajm.prototipo.prototipotelas.R;
import br.com.trabalhosemestral.model.Producao;
import br.com.trabalhosemestral.model.Produto;
import br.com.trabalhosemestral.service.ProducaoService;
import br.com.trabalhosemestral.service.ProdutoService;


public class ProducaoListaActivity extends AppCompatActivity {

    private ListView lvRegistros;
    ArrayAdapter<String> adaptador;
    final List<String> ProducoesDaLista = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producao_lista_layout);

        lvRegistros = (ListView) findViewById(R.id.listv_producoes);
        lvRegistros.setLongClickable(true);

        ListarProducoes();
        //AbrirOpcoes();
    }
    public void ProduzirProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), ProducaoActivity.class);
        startActivity(intent);
    }
    public void Voltar(View view) {

        finish();
    }

    public void ListarProducoes() {
        final ProducaoService service = new ProducaoService();
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
                        List<Producao> producoes = service.ListarTodos();
                        for (Producao p : producoes ) {
                            ProducoesDaLista.add(p.getId() + "-" + p.getOrdem_producao());
                        }
                        adaptador = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, ProducoesDaLista);
                        lvRegistros.setAdapter(adaptador);
                    }
                };
        tarefa.execute();
    }
}
