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

public class DicRomanToMorseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic_roman_to_morse);

        Translator translator = new Translator();

        TextView title = findViewById(R.id.title);
        title.setText("Dicionário Romano -> Morse");

        final ListView listDicLeft = findViewById(R.id.listDicLeft);
        final ListView listDicRight = findViewById(R.id.listDicRight);

        ArrayList<String> arrayListDicLeft = new ArrayList<>();
        ArrayList<String> arrayListDicRight = new ArrayList<>();

        arrayListDicLeft.add("a");
        arrayListDicLeft.add("b");
        arrayListDicLeft.add("c");
        arrayListDicLeft.add("d");
        arrayListDicLeft.add("e");
        arrayListDicLeft.add("f");
        arrayListDicLeft.add("g");
        arrayListDicLeft.add("h");
        arrayListDicLeft.add("i");
        arrayListDicLeft.add("j");
        arrayListDicLeft.add("k");
        arrayListDicLeft.add("l");
        arrayListDicLeft.add("m");
        arrayListDicLeft.add("n");
        arrayListDicLeft.add("o");
        arrayListDicLeft.add("p");
        arrayListDicLeft.add("q");
        arrayListDicLeft.add("r");
        arrayListDicLeft.add("s");
        arrayListDicLeft.add("t");
        arrayListDicLeft.add("u");
        arrayListDicLeft.add("v");
        arrayListDicLeft.add("w");
        arrayListDicLeft.add("x");
        arrayListDicLeft.add("y");
        arrayListDicLeft.add("z");
        arrayListDicLeft.add("0");
        arrayListDicLeft.add("1");
        arrayListDicLeft.add("2");
        arrayListDicLeft.add("3");
        arrayListDicLeft.add("4");
        arrayListDicLeft.add("5");
        arrayListDicLeft.add("6");
        arrayListDicLeft.add("7");
        arrayListDicLeft.add("8");
        arrayListDicLeft.add("9");

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

        arrayListDicRight.add(translator.charToMorse('a'));
        arrayListDicRight.add(translator.charToMorse('b'));
        arrayListDicRight.add(translator.charToMorse('c'));
        arrayListDicRight.add(translator.charToMorse('d'));
        arrayListDicRight.add(translator.charToMorse('e'));
        arrayListDicRight.add(translator.charToMorse('f'));
        arrayListDicRight.add(translator.charToMorse('g'));
        arrayListDicRight.add(translator.charToMorse('h'));
        arrayListDicRight.add(translator.charToMorse('i'));
        arrayListDicRight.add(translator.charToMorse('j'));
        arrayListDicRight.add(translator.charToMorse('k'));
        arrayListDicRight.add(translator.charToMorse('l'));
        arrayListDicRight.add(translator.charToMorse('m'));
        arrayListDicRight.add(translator.charToMorse('n'));
        arrayListDicRight.add(translator.charToMorse('o'));
        arrayListDicRight.add(translator.charToMorse('p'));
        arrayListDicRight.add(translator.charToMorse('q'));
        arrayListDicRight.add(translator.charToMorse('r'));
        arrayListDicRight.add(translator.charToMorse('s'));
        arrayListDicRight.add(translator.charToMorse('t'));
        arrayListDicRight.add(translator.charToMorse('u'));
        arrayListDicRight.add(translator.charToMorse('v'));
        arrayListDicRight.add(translator.charToMorse('w'));
        arrayListDicRight.add(translator.charToMorse('x'));
        arrayListDicRight.add(translator.charToMorse('y'));
        arrayListDicRight.add(translator.charToMorse('z'));
        arrayListDicRight.add(translator.charToMorse('0'));
        arrayListDicRight.add(translator.charToMorse('1'));
        arrayListDicRight.add(translator.charToMorse('2'));
        arrayListDicRight.add(translator.charToMorse('3'));
        arrayListDicRight.add(translator.charToMorse('4'));
        arrayListDicRight.add(translator.charToMorse('5'));
        arrayListDicRight.add(translator.charToMorse('6'));
        arrayListDicRight.add(translator.charToMorse('7'));
        arrayListDicRight.add(translator.charToMorse('8'));
        arrayListDicRight.add(translator.charToMorse('9'));

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
