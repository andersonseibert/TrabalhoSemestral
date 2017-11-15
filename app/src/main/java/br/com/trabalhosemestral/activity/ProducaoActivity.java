package br.com.trabalhosemestral.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by rossi on 15/11/2017.
 */

public class ProducaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producao_layout);

    }
    public void Sair(View view) {

        finish();
    }
}
