package br.com.trabalhosemestral.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by rossi on 15/11/2017.
 */

public class ProducaoActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producao_layout);
        final ListView listView = (ListView) findViewById(R.id.listv);

//        arrayList = new ArrayList<>();
//        adapter = new ArrayAdapter<String>(ProducaoActivity.this, android.R.layout.simple_expandable_list_item_1, arrayList);
//        listView.setAdapter(adapter);
//        registerForContextMenu(listView);
//    }
//
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
    }


    public void Sair(View view) {

        finish();
    }
}
