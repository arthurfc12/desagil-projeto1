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


        final ListView listDicRight = findViewById(R.id.listDic);

        ArrayList<String> arrayListDicRight = new ArrayList<>();

        arrayListDicRight.add(translator.charToMorse('e')+"     -->       e");
        arrayListDicRight.add(translator.charToMorse('t')+"     -->       t");
        arrayListDicRight.add(translator.charToMorse('i')+"    -->       i");
        arrayListDicRight.add(translator.charToMorse('a')+"    -->      a");
        arrayListDicRight.add(translator.charToMorse('n')+"    -->      n");
        arrayListDicRight.add(translator.charToMorse('m')+"    -->      m");
        arrayListDicRight.add(translator.charToMorse('s')+"   -->      s");
        arrayListDicRight.add(translator.charToMorse('u')+"   -->      u");
        arrayListDicRight.add(translator.charToMorse('r')+"   -->      r");
        arrayListDicRight.add(translator.charToMorse('w')+"   -->      w");
        arrayListDicRight.add(translator.charToMorse('d')+"   -->      d");
        arrayListDicRight.add(translator.charToMorse('k')+"   -->      k");
        arrayListDicRight.add(translator.charToMorse('g')+"   -->      g");
        arrayListDicRight.add(translator.charToMorse('o')+"   -->      o");
        arrayListDicRight.add(translator.charToMorse('h')+"   -->     h");
        arrayListDicRight.add(translator.charToMorse('v')+"   -->     v");
        arrayListDicRight.add(translator.charToMorse('f')+"   -->     f");
        arrayListDicRight.add(translator.charToMorse('l')+"   -->     l");
        arrayListDicRight.add(translator.charToMorse('p')+"   -->     p");
        arrayListDicRight.add(translator.charToMorse('j')+"   -->     j");
        arrayListDicRight.add(translator.charToMorse('b')+"   -->     b");
        arrayListDicRight.add(translator.charToMorse('x')+"   -->     x");
        arrayListDicRight.add(translator.charToMorse('c')+"   -->     c");
        arrayListDicRight.add(translator.charToMorse('y')+"   -->     y");
        arrayListDicRight.add(translator.charToMorse('z')+"   -->     z");
        arrayListDicRight.add(translator.charToMorse('q')+"   -->     q");
        arrayListDicRight.add(translator.charToMorse('5')+"  -->     5");
        arrayListDicRight.add(translator.charToMorse('4')+"  -->     4");
        arrayListDicRight.add(translator.charToMorse('3')+"  -->     3");
        arrayListDicRight.add(translator.charToMorse('2')+"  -->     2");
        arrayListDicRight.add(translator.charToMorse('1')+"  -->     1");
        arrayListDicRight.add(translator.charToMorse('6')+"  -->     6");
        arrayListDicRight.add(translator.charToMorse('7')+"  -->     7");
        arrayListDicRight.add(translator.charToMorse('8')+"  -->     8");
        arrayListDicRight.add(translator.charToMorse('9')+"  -->     9");
        arrayListDicRight.add(translator.charToMorse('0')+"  -->     0");

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
