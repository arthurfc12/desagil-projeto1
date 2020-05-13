package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Button_Morse extends AppCompatActivity {
    private static final int LIST_ACTIVITY_REQUEST_CODE = 0;
    Translator tradutor = new Translator();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> history_list;
    boolean typePhone = true;

    public void startListActivity() {
        Intent startListActivity = new Intent(this, ListActivity.class);

        startActivityForResult(startListActivity, LIST_ACTIVITY_REQUEST_CODE);
    }

    private void showToast(String text) {

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__morse2);

        //TextView where the message is written
        TextView escrita = findViewById(R.id.Title_button);
        //Phone number input
        EditText textPhone = findViewById(R.id.textPhone);
        //Button to write the morse code
        Button button_morse = findViewById(R.id.ButtonMorse);
        //Button to send the word from the ListView to the message
        Button buttonToList = findViewById(R.id.buttonGoToList);
        //Button to add a space in the message
        Button space = findViewById(R.id.space);
        //Button to start the converter
        Button endChar = findViewById(R.id.endChar);
        //Button that shows the dictionary from Roman to Morse code
        Button buttonToCharToMorseDic = findViewById(R.id.buttonGoToDicRomanToMorse);
        //Button that shows the dictionary from Morse code to Roman
        Button buttonToMorseToRomanDic = findViewById(R.id.buttonGoToDicMorseToRoman);
        //Send button
        Button buttonSend = findViewById(R.id.buttonSend);
        //List of most common phrases
        ListView history = findViewById(R.id.history);
        //Backspace button
        Button backspace = findViewById(R.id.buttonErase);
        //Erase All
        Button buttonEraseAll = findViewById(R.id.buttonEraseAll);
        //Set phone button
        Button setPhone = findViewById(R.id.buttonSetPhone);

        history_list = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, history_list);

        //Button to change the phone Number
        setPhone.setOnClickListener((view) -> {
            if (typePhone){
                typePhone = false;
                setPhone.setText("Change phone");
                showToast("Phone number setted");
                return;
            }else {
                typePhone = true;
                textPhone.setText("");
                setPhone.setText("Set phone");
                showToast("You can now edit the phone");
                return;
            }
        });
        //Button to add a space on the morse code
        space.setOnClickListener((view) -> {
            if (typePhone){
                String text = textPhone.getText().toString();
                String dado = " ";
                String content = text+ dado;
                textPhone.setText(content);
            }else {
                String text = escrita.getText().toString();
                String dado = " ";
                String content = text+ dado;
                escrita.setText(content);
            }
        });

        //Button to delete last string from morse code
        backspace.setOnClickListener((view)->{
            if (typePhone){
                String text = textPhone.getText().toString();
                if (text.length()>0){
                    text = text.substring(0, text.length()-1);
                    textPhone.setText(text);
                }
            } else{
                String text = escrita.getText().toString();
                if (text.length()>0){
                    text = text.substring(0, text.length()-1);
                    escrita.setText(text);
                }
            }

        });

        buttonEraseAll.setOnClickListener((view) -> {
            if (typePhone){
                if (textPhone.length() != 0) {
                    textPhone.setText("");
                }
            } else {
                if (escrita.length() != 0) {
                    escrita.setText("");
                }
            }
        });

        //Button to convert morse code to dic
        endChar.setOnClickListener((view) -> {
            if (typePhone){
                String text = textPhone.getText().toString();
                String morse = null;
                String n_morse = null;
                if (text.length() != 0) {
                    if ((text.contains("-"))) {
                        if ((text.contains("."))) { //Tem os 2
                            if (text.indexOf('-') < text.indexOf('.')) { // - vem antes
                                morse = text.substring(text.indexOf('-'));
                                n_morse = text.substring(0, text.indexOf('-'));
                            } else {// . vem antes
                                morse = text.substring(text.indexOf('.'));
                                n_morse = text.substring(0, text.indexOf('.'));
                            }
                        } else { //so tem "-"
                            morse = text.substring(text.indexOf('-'));
                            n_morse = text.substring(0, text.indexOf('-'));
                        }
                    } else if ((text.contains("."))) { //So tem .
                        morse = text.substring(text.indexOf('.'));
                        n_morse = text.substring(0, text.indexOf('.'));
                    }
                    if ((text.contains(".")) || (text.contains("-"))) {
                        char letra;
                        System.out.println(morse);
                        try {
                            letra = tradutor.morseToChar(morse);
                            String content = n_morse + letra;
                            textPhone.setText(content);
                        } catch (Exception e) {
                            textPhone.setText(n_morse);
                        }
                    }
                } else {

                }
            } else{
                String text = escrita.getText().toString();
                String morse = null;
                String n_morse = null;
                if (text.length() != 0) {
                    if ((text.contains("-"))) {
                        if ((text.contains("."))) { //Tem os 2
                            if (text.indexOf('-') < text.indexOf('.')) { // - vem antes
                                morse = text.substring(text.indexOf('-'));
                                n_morse = text.substring(0, text.indexOf('-'));
                            } else {// . vem antes
                                morse = text.substring(text.indexOf('.'));
                                n_morse = text.substring(0, text.indexOf('.'));
                            }
                        } else { //so tem "-"
                            morse = text.substring(text.indexOf('-'));
                            n_morse = text.substring(0, text.indexOf('-'));
                        }
                    } else if ((text.contains("."))) { //So tem .
                        morse = text.substring(text.indexOf('.'));
                        n_morse = text.substring(0, text.indexOf('.'));
                    }
                    if ((text.contains(".")) || (text.contains("-"))) {
                        char letra;
                        System.out.println(morse);
                        try {
                            letra = tradutor.morseToChar(morse);
                            String content = n_morse + letra;
                            escrita.setText(content);
                        } catch (Exception e) {
                            escrita.setText(n_morse);
                        }

                    }
                } else {
                }
            }
        });
        //Button to send messages and show these messages in the history of last sent messages
        buttonSend.setOnClickListener((view) -> {
            String lastSend = escrita.getText().toString();
            if (lastSend.length() > 0) {
                history_list.add(lastSend);
                history.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
            String message = escrita.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }
            String phone = textPhone.getText().toString();

            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            escrita.setText("");
        });
        //Button to write morse code
        button_morse.setOnClickListener((view) -> {
            if (typePhone){
                String text = textPhone.getText().toString();
                String dado = ".";
                String content = text + dado;
                textPhone.setText(content);
            }else {
                String text = escrita.getText().toString();
                String dado = ".";
                String content = text + dado;
                escrita.setText(content);
            }
        });

        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String history_item = (String) history.getItemAtPosition(position);
                String text = escrita.getText().toString();
                String content = text + history_item;
                escrita.setText(content);
            }
        });

        //Button to write morse code
        button_morse.setOnLongClickListener((view) -> {
            if (typePhone){
                String text = textPhone.getText().toString();
                String dado = "-";
                String content = text + dado;
                textPhone.setText(content);

            }else {
                String text = escrita.getText().toString();
                String dado = "-";
                String content = text + dado;
                escrita.setText(content);
            }
            return true;
        });

        buttonToList.setOnClickListener((view) -> {
            startListActivity();
        });

        //Converting the letters from the morse code to dic
        buttonToCharToMorseDic.setText("RM");
        buttonToCharToMorseDic.setOnClickListener((view) -> {
            Intent startDicCharToMorse = new Intent(Button_Morse.this, DicRomanToMorseActivity.class);
            startActivity(startDicCharToMorse);
        });

        buttonToMorseToRomanDic.setText("MR");
        buttonToMorseToRomanDic.setOnClickListener((view) -> {
            Intent startDicCharToMorse = new Intent(Button_Morse.this, DicMorseToRoman.class);
            startActivity(startDicCharToMorse);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LIST_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra(Intent.EXTRA_TEXT);

                TextView escrita = (TextView) findViewById(R.id.Title_button);
                escrita.setText(returnString);
            }
        }
    }
}