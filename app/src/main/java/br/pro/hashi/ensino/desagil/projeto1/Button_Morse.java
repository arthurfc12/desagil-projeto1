package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Button_Morse extends AppCompatActivity {
    Translator tradutor= new Translator();
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
        Button buttonToCharToMorseDic = findViewById(R.id.buttonGoToDic1);
        Button buttonErase = findViewById(R.id.buttonErase);
        Button buttonEraseAll = findViewById(R.id.buttonEraseAll);

        space.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = " ";
            String content = text+ dado;
            escrita.setText(content);
        });

        endChar.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String morse=null;
            String n_morse=null;
            if (text.length()!=0){
                System.out.println("maior q 0") ;
                if ((text.contains("-"))){
                    if((text.contains("."))){ //Tem os 2
                        if (text.indexOf('-')<text.indexOf('.')){ // - vem antes
                            morse = text.substring(text.indexOf('-'));
                            n_morse = text.substring(0,text.indexOf('-'));
                        }else {// . vem antes
                            morse = text.substring(text.indexOf('.'));
                            n_morse = text.substring(0,text.indexOf('.'));
                        }
                    }else{ //so tem "-"
                        morse = text.substring(text.indexOf('-'));
                        n_morse = text.substring(0,text.indexOf('-'));
                    }

                }else if((text.contains("."))){ //So tem .
                    morse = text.substring(text.indexOf('.'));
                    n_morse = text.substring(0,text.indexOf('.'));
                }
                if((text.contains("."))||(text.contains("-"))){


                    System.out.println(morse);
                    char letra= tradutor.morseToChar(morse);
                    String content = n_morse + letra;
                    escrita.setText(content);
                }
            }else{
                System.out.println("Parabens vc quer criar um char sem codigo morse!!! Repense sua vida");

            }

        });

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

        buttonToCharToMorseDic.setText("RM");
        buttonToCharToMorseDic.setOnClickListener((view) -> {
            Intent startDicCharToMorse = new Intent(Button_Morse.this, DicRomanToMorseActivity.class);
            startActivity(startDicCharToMorse);
        });

        buttonErase.setOnClickListener((view) -> {
            if (escrita.length() != 0) {
                String tudo = escrita.getText().toString();
                String novo = tudo.substring(0, tudo.length()-1);
                escrita.setText(novo);
            }
        });

        buttonEraseAll.setOnClickListener((view) -> {
            if (escrita.length() != 0) {
                escrita.setText("");
            }
        });
    }
}