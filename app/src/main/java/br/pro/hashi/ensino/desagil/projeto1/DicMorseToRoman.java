package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DicMorseToRoman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic_morse_to_roman);

        Translator translator = new Translator();

        TextView title = findViewById(R.id.title);
        title.setText("Dicionário Morse -> Roman");


        final ListView listDicRight = findViewById(R.id.listDicRight);

        ArrayList<String> arrayListDicRight = new ArrayList<>();

        arrayListDicRight.add("e     -->     "+ translator.charToMorse('e'));
        arrayListDicRight.add("t     -->     "+ translator.charToMorse('t'));
        arrayListDicRight.add("i     -->    "+ translator.charToMorse('i'));
        arrayListDicRight.add("a     -->    "+ translator.charToMorse('a'));
        arrayListDicRight.add("n     -->    "+ translator.charToMorse('n'));
        arrayListDicRight.add("m     -->    "+ translator.charToMorse('m'));
        arrayListDicRight.add("s     -->   "+ translator.charToMorse('s'));
        arrayListDicRight.add("u     -->   "+ translator.charToMorse('u'));
        arrayListDicRight.add("r     -->   "+ translator.charToMorse('r'));
        arrayListDicRight.add("w     -->   "+ translator.charToMorse('w'));
        arrayListDicRight.add("d     -->   "+ translator.charToMorse('d'));
        arrayListDicRight.add("k     -->   "+ translator.charToMorse('k'));
        arrayListDicRight.add("g     -->   "+ translator.charToMorse('g'));
        arrayListDicRight.add("o     -->   "+ translator.charToMorse('o'));
        arrayListDicRight.add("h     -->  "+ translator.charToMorse('h'));
        arrayListDicRight.add("v     -->  "+ translator.charToMorse('v'));
        arrayListDicRight.add("f     -->  "+ translator.charToMorse('f'));
        arrayListDicRight.add("l     -->  "+ translator.charToMorse('l'));
        arrayListDicRight.add("p     -->  "+ translator.charToMorse('p'));
        arrayListDicRight.add("j     -->  "+ translator.charToMorse('j'));
        arrayListDicRight.add("b     -->  "+ translator.charToMorse('b'));
        arrayListDicRight.add("x     -->  "+ translator.charToMorse('x'));
        arrayListDicRight.add("c     -->  "+ translator.charToMorse('c'));
        arrayListDicRight.add("y     -->  "+ translator.charToMorse('y'));
        arrayListDicRight.add("z     -->  "+ translator.charToMorse('z'));
        arrayListDicRight.add("q     -->  "+ translator.charToMorse('q'));
        arrayListDicRight.add("5     --> "+ translator.charToMorse('5'));
        arrayListDicRight.add("4     --> "+ translator.charToMorse('4'));
        arrayListDicRight.add("3     --> "+ translator.charToMorse('3'));
        arrayListDicRight.add("2     --> "+ translator.charToMorse('2'));
        arrayListDicRight.add("1     --> "+ translator.charToMorse('1'));
        arrayListDicRight.add("6     --> "+ translator.charToMorse('6'));
        arrayListDicRight.add("7     --> "+ translator.charToMorse('7'));
        arrayListDicRight.add("8     --> "+ translator.charToMorse('8'));
        arrayListDicRight.add("9     --> "+ translator.charToMorse('9'));
        arrayListDicRight.add("0     --> "+ translator.charToMorse('0'));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListDicRight) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);

                // Return the view
                return view;
            }
        };
        listDicRight.setAdapter(arrayAdapter);

    }
}
