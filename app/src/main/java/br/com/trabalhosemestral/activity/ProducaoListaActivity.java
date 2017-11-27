package br.com.trabalhosemestral.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.ajm.prototipo.prototipotelas.R;


public class ProducaoListaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producao_lista_layout);

    }
    public void ProduzirProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), ProducaoActivity.class);
        startActivity(intent);
    }
    public void Voltar(View view) {

        finish();
    }
}
