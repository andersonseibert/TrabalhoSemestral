package br.com.trabalhosemestral.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by rossi on 15/11/2017.
 */

public class ProdutosCadastradosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produtos_cadastrados_layout);

    }
    public void AbreCadastroProdutos(View view) {
        Intent intent = new Intent(getBaseContext(), CadastroProdutoActivity.class);
        startActivity(intent);
    }

    public void Voltar(View view) {

        finish();
    }

}
