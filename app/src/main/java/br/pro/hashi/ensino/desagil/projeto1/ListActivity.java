package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ListView list = findViewById(R.id.list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Estou com fome");
        arrayList.add("Quero ir ao banheiro");
        arrayList.add("Estou me sentido mal");
        arrayList.add("Acho que estou doente");
        arrayList.add("Estou sentindo dores");
        arrayList.add("Estou com frio");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, Button_Morse.class);
                String itemClicked = (String) list.getItemAtPosition(position);
                intent.putExtra(Intent.EXTRA_TEXT, itemClicked);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
