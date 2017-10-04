package com.br.trabalhosemestral.model;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ajm.prototipo.prototipotelas.R;

/**
 * Created by rossi on 04/10/2017.
 */

public class Estoque extends Activity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    private EditText editText9;
    private EditText editText11;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.estoque);
        final ListView listView = (ListView) findViewById(R.id.listv);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(Estoque.this, android.R.layout.simple_expandable_list_item_1, arrayList);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText11 = (EditText) findViewById(R.id.editText11);

        Button btAdd = (Button) findViewById(R.id.button4);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText9.getText().length() == 0) {

                    editText9.setError("Campo vazio");

                } else if (editText11.getText().length() == 0) {

                    editText11.setError("Campo vazio");

                } else {

                    String ingrediente = editText9.getText().toString();
                    String quantidade = editText11.getText().toString();

                    editText9.setText("");
                    editText11.setText("");

                    arrayList.add(ingrediente + " - " + quantidade);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        registerForContextMenu(listView);

//        listContatos = (TextView) findViewById(R.id.listContatos);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listv) {
            menu.add("Remover");

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 0:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Atenção!");
                builder.setMessage("Deseja remover ingrediente?");
                builder.setCancelable(true);

                builder.setPositiveButton("Sim", null);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        arrayList.remove(info.position);
                        adapter.notifyDataSetChanged();
                    }
                })
                        .setNegativeButton("Cancelar", null)
                        .show();
//                AlertDialog dialog=builder.create();
//                dialog.show();
        }
        return true;
    }
}