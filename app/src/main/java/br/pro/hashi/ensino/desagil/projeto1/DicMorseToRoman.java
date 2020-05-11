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

        final ListView listDicLeft = findViewById(R.id.listDicLeft);
        final ListView listDicRight = findViewById(R.id.listDicRight);

        ArrayList<String> arrayListDicLeft = new ArrayList<>();
        ArrayList<String> arrayListDicRight = new ArrayList<>();

        arrayListDicRight.add("e");
        arrayListDicRight.add("t");
        arrayListDicRight.add("i");
        arrayListDicRight.add("a");
        arrayListDicRight.add("n");
        arrayListDicRight.add("m");
        arrayListDicRight.add("s");
        arrayListDicRight.add("u");
        arrayListDicRight.add("r");
        arrayListDicRight.add("w");
        arrayListDicRight.add("d");
        arrayListDicRight.add("k");
        arrayListDicRight.add("g");
        arrayListDicRight.add("o");
        arrayListDicRight.add("h");
        arrayListDicRight.add("v");
        arrayListDicRight.add("f");
        arrayListDicRight.add("l");
        arrayListDicRight.add("p");
        arrayListDicRight.add("j");
        arrayListDicRight.add("b");
        arrayListDicRight.add("x");
        arrayListDicRight.add("c");
        arrayListDicRight.add("y");
        arrayListDicRight.add("z");
        arrayListDicRight.add("q");
        arrayListDicRight.add("0");
        arrayListDicRight.add("1");
        arrayListDicRight.add("2");
        arrayListDicRight.add("3");
        arrayListDicRight.add("4");
        arrayListDicRight.add("5");
        arrayListDicRight.add("6");
        arrayListDicRight.add("7");
        arrayListDicRight.add("8");
        arrayListDicRight.add("9");

        ArrayAdapter<String> arrayAdapterLeft = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListDicLeft) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
                tv.setGravity(Gravity.CENTER);

                // Return the view
                return view;
            }
        };
        listDicLeft.setAdapter(arrayAdapterLeft);

        arrayListDicLeft.add(translator.charToMorse('e'));
        arrayListDicLeft.add(translator.charToMorse('t'));
        arrayListDicLeft.add(translator.charToMorse('i'));
        arrayListDicLeft.add(translator.charToMorse('a'));
        arrayListDicLeft.add(translator.charToMorse('n'));
        arrayListDicLeft.add(translator.charToMorse('m'));
        arrayListDicLeft.add(translator.charToMorse('s'));
        arrayListDicLeft.add(translator.charToMorse('u'));
        arrayListDicLeft.add(translator.charToMorse('r'));
        arrayListDicLeft.add(translator.charToMorse('w'));
        arrayListDicLeft.add(translator.charToMorse('d'));
        arrayListDicLeft.add(translator.charToMorse('k'));
        arrayListDicLeft.add(translator.charToMorse('g'));
        arrayListDicLeft.add(translator.charToMorse('o'));
        arrayListDicLeft.add(translator.charToMorse('h'));
        arrayListDicLeft.add(translator.charToMorse('v'));
        arrayListDicLeft.add(translator.charToMorse('f'));
        arrayListDicLeft.add(translator.charToMorse('l'));
        arrayListDicLeft.add(translator.charToMorse('p'));
        arrayListDicLeft.add(translator.charToMorse('j'));
        arrayListDicLeft.add(translator.charToMorse('b'));
        arrayListDicLeft.add(translator.charToMorse('x'));
        arrayListDicLeft.add(translator.charToMorse('c'));
        arrayListDicLeft.add(translator.charToMorse('y'));
        arrayListDicLeft.add(translator.charToMorse('z'));
        arrayListDicLeft.add(translator.charToMorse('q'));
        arrayListDicLeft.add(translator.charToMorse('0'));
        arrayListDicLeft.add(translator.charToMorse('1'));
        arrayListDicLeft.add(translator.charToMorse('2'));
        arrayListDicLeft.add(translator.charToMorse('3'));
        arrayListDicLeft.add(translator.charToMorse('4'));
        arrayListDicLeft.add(translator.charToMorse('5'));
        arrayListDicLeft.add(translator.charToMorse('6'));
        arrayListDicLeft.add(translator.charToMorse('7'));
        arrayListDicLeft.add(translator.charToMorse('8'));
        arrayListDicLeft.add(translator.charToMorse('9'));

        ArrayAdapter<String> arrayAdapterRight = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListDicRight) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
                tv.setGravity(Gravity.CENTER);

                // Return the view
                return view;
            }
        };
        listDicRight.setAdapter(arrayAdapterRight);



    }
}
