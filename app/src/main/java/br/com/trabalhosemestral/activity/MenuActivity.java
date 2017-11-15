package br.com.trabalhosemestral.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.ajm.prototipo.prototipotelas.R;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal_layout);
    }

    public void AbreCadastroProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), CadastroProdutoActivity.class);
        startActivity(intent);
    }

    public void ListaCadastrados(View view) {
        Intent intent = new Intent(getBaseContext(), ProdutosCadastradosActivity.class);
        startActivity(intent);
    }
    public void ProduzirProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), ProducaoActivity.class);
        startActivity(intent);
    }

    public void ListaProduzidos(View view) {
        Intent intent = new Intent(getBaseContext(), ProducaoListaActivity.class);
        startActivity(intent);
    }

    public void FinalizarAplicacao(View view) {
        finish();
    }
}
