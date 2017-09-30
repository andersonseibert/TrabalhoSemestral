package com.br.trabalhosemestral.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by Anderson on 29/09/2017.
 */

public class CadastroUsuarioActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrousuario_layout);
    }

    public void VoltarTelaLogin(View view){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
    }
}
