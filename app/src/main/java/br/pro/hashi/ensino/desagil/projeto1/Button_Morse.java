package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Button_Morse extends AppCompatActivity {
    Translator tradutor = new Translator();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> history_list;

    public void startListActivity() {
        Intent startListActivity = new Intent(this, ListActivity.class);

        startActivity(startListActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__morse2);

        //TextView where the message is written
        TextView escrita = findViewById(R.id.Title_button);
        //Button to write the morse code
        Button button_morse = findViewById(R.id.ButtonMorse);
        //Button to send the word from the ListView to the message
        Button buttonToList = findViewById(R.id.buttonGoToList);
        //Button to add a space in the message
        Button space = findViewById(R.id.space);
        //Button to start the converter
        Button endChar = findViewById(R.id.endChar);
        //Button that shows the dictionary for the morse code
        Button buttonToCharToMorseDic = findViewById(R.id.buttonGoToDic1);
        //Send button
        Button buttonSend = findViewById(R.id.buttonSend);
        //List of most common phrases
        ListView history = findViewById(R.id.history);
        //Backspace button
        Button backspace = findViewById(R.id.buttonErase);
        //Erase All
        Button buttonEraseAll = findViewById(R.id.buttonEraseAll);

        //Button to add a space on the morse code
        space.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = " ";
            String content = text+ dado;
            escrita.setText(content);
        });

        //Button to delete last string from morse code
        backspace.setOnClickListener((view)->{
            String text = escrita.getText().toString();
            if (text.length()>0){
                text = text.substring(0, text.length()-1);
                escrita.setText(text);
            }
        });

        buttonEraseAll.setOnClickListener((view) -> {
            if (escrita.length() != 0) {
                escrita.setText("");
            }
        });

        //Button to convert morse code to dic
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
                    char letra;
                    System.out.println(morse);
                    try {
                        letra = tradutor.morseToChar(morse);
                    }catch (Exception e){
                        letra='\0';
                        System.out.println("Digite o Morse Corretamente pf meu caro imbecil!!!");
                    }
                    String content = n_morse + letra;
                    escrita.setText(content);
                }
            }else{
                System.out.println("Parabens vc quer criar um char sem codigo morse!!! Repense sua vida");

            }

        });

        history_list = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, history_list);

        //Button to send messages and show these messages in the history of last sent messages
        buttonSend.setOnClickListener((view) -> {
            String lastSend = escrita.getText().toString();
            if (lastSend.length() > 0) {
                history_list.add(lastSend);
                history.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
            escrita.setText("");
        });

        //Button to write morse code
        button_morse.setOnClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = ".";
            String content = text+ dado;
            escrita.setText(content);
        });

        //Button to write morse code
        button_morse.setOnLongClickListener((view) -> {
            String text = escrita.getText().toString();
            String dado = "-";
            String content = text+ dado;
            escrita.setText(content);
            return true;
        });

        //Sending the ListView item choosed to the MainActivity TextView where the message is been written
        Intent intentFromList = getIntent();
        escrita.setText(intentFromList.getStringExtra("string"));

        buttonToList.setOnClickListener((view) -> {
            startListActivity();
        });

        //Converting the letters from the morse code to dic
        buttonToCharToMorseDic.setText("RM");
        buttonToCharToMorseDic.setOnClickListener((view) -> {
            Intent startDicCharToMorse = new Intent(Button_Morse.this, DicRomanToMorseActivity.class);
            startActivity(startDicCharToMorse);
        });
    }
}