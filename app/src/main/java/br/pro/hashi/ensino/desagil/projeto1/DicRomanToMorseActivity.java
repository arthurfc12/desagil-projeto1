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

        final ListView listDic = findViewById(R.id.listDic);

        ArrayList<String> arrayListDic = new ArrayList<>();

        arrayListDic.add("a     -->    "+ translator.charToMorse('a'));
        arrayListDic.add("b     -->  "+ translator.charToMorse('b'));
        arrayListDic.add("c     -->  "+ translator.charToMorse('c'));
        arrayListDic.add("d     -->   "+ translator.charToMorse('d'));
        arrayListDic.add("e     -->     "+ translator.charToMorse('e'));
        arrayListDic.add("f      -->  "+ translator.charToMorse('f'));
        arrayListDic.add("g     -->   "+ translator.charToMorse('g'));
        arrayListDic.add("h     -->  "+ translator.charToMorse('h'));
        arrayListDic.add("i      -->    "+ translator.charToMorse('i'));
        arrayListDic.add("j      -->  "+ translator.charToMorse('j'));
        arrayListDic.add("k     -->   "+ translator.charToMorse('k'));
        arrayListDic.add("l      -->  "+ translator.charToMorse('l'));
        arrayListDic.add("m    -->    "+ translator.charToMorse('m'));
        arrayListDic.add("n     -->    "+ translator.charToMorse('n'));
        arrayListDic.add("o     -->   "+ translator.charToMorse('o'));
        arrayListDic.add("p     -->  "+ translator.charToMorse('p'));
        arrayListDic.add("q     -->  "+ translator.charToMorse('q'));
        arrayListDic.add("r      -->   "+ translator.charToMorse('r'));
        arrayListDic.add("s     -->   "+ translator.charToMorse('s'));
        arrayListDic.add("t      -->     "+ translator.charToMorse('t'));
        arrayListDic.add("u     -->   "+ translator.charToMorse('u'));
        arrayListDic.add("v     -->  "+ translator.charToMorse('v'));
        arrayListDic.add("w    -->   "+ translator.charToMorse('w'));
        arrayListDic.add("x     -->  "+ translator.charToMorse('x'));
        arrayListDic.add("y     -->  "+ translator.charToMorse('y'));
        arrayListDic.add("z     -->  "+ translator.charToMorse('z'));
        arrayListDic.add("1     --> "+ translator.charToMorse('1'));
        arrayListDic.add("2     --> "+ translator.charToMorse('2'));
        arrayListDic.add("3     --> "+ translator.charToMorse('3'));
        arrayListDic.add("4     --> "+ translator.charToMorse('4'));
        arrayListDic.add("5     --> "+ translator.charToMorse('5'));
        arrayListDic.add("6     --> "+ translator.charToMorse('6'));
        arrayListDic.add("7     --> "+ translator.charToMorse('7'));
        arrayListDic.add("8     --> "+ translator.charToMorse('8'));
        arrayListDic.add("9     --> "+ translator.charToMorse('9'));
        arrayListDic.add("0     --> "+ translator.charToMorse('0'));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListDic) {
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

        listDic.setAdapter(arrayAdapter);

    }
}
