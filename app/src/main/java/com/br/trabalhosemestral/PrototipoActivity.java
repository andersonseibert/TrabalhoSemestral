package com.br.trabalhosemestral;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by rossi on 13/09/2017.
 */

public class PrototipoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.prototipo);
//        setContentView(R.layout.cadusuario);
//        setContentView(R.layout.menu);
//        setContentView(R.layout.estoque);
        setContentView(R.layout.producao);
    }
}
