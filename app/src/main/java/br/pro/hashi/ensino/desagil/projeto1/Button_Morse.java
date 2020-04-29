package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Button_Morse extends AppCompatActivity {

    public void startListActivity() {
        Intent startListActivity = new Intent(this, ListActivity.class);

        startActivity(startListActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__morse2);
        
        TextView escrita = findViewById(R.id.Title_button);
        Button button_morse = findViewById(R.id.ButtonMorse);
        Button buttonToList = findViewById(R.id.buttonGoToList);
        Button space = findViewById(R.id.space);
        Button endChar = findViewById(R.id.endChar);

        space.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = " ";
            String content = text+ dado;
            escrita.setText(content);
        });

      /*  endChar.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = " ";
            String content = text+ dado;
            escrita.setText(content);
        }); */

        button_morse.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = ".";
            String content = text+ dado;
            escrita.setText(content);
        });
        button_morse.setOnLongClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = "-";
            String content = text+ dado;
            escrita.setText(content);
            return true;
        });
        Intent intentFromList = getIntent();
        escrita.setText(intentFromList.getStringExtra("string"));

        buttonToList.setOnClickListener((view) -> {
            startListActivity();
        });
    }
}