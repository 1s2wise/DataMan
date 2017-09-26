package com.example.android.dataman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by root on 22/9/17.
 */

public class ChildActivity extends AppCompatActivity {
    EditText disp;
    Button b3;
    ScrollView scrollv,scroll1;
    TextView txv;
    String gotText, newtxt, deEnc;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);


        scrollv = (ScrollView) findViewById(R.id.sv2);
        scroll1 = (ScrollView) findViewById(R.id.sv1);
        txv = (TextView) findViewById(R.id.tv2);

        b3 = (Button) findViewById(R.id.button3);
        disp = (EditText) findViewById(R.id.listener);
        Intent intentParent = getIntent();
        if (intentParent.hasExtra(Intent.EXTRA_TEXT)){
            setInVisible();
            gotText = intentParent.getStringExtra(Intent.EXTRA_TEXT);
            disp.setText(gotText);

        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisible();

                newtxt = disp.getText().toString();
                char[] ch = newtxt.toCharArray();
                int i=0,j;
                char temp;


                if(ch[0]==',' && ch[1]==',') {

                    for (i = 2; i < ch.length; i++) {
                        temp = ch[i];
                        j = (int) temp;
                        j -= 3;
                        ch[i] = (char) j;
                    }
                }
                deEnc = String.valueOf(ch);
                deEnc = deEnc.substring(2);
                txv.setText(deEnc);

            }
        });
    }
    public void setInVisible(){
        scrollv.setVisibility(View.INVISIBLE);
        txv.setVisibility(View.INVISIBLE);

    }
    public void setVisible(){
        scrollv.setVisibility(View.VISIBLE);
        txv.setVisibility(View.VISIBLE);
        scroll1.setVisibility(View.INVISIBLE);
        disp.setVisibility(View.INVISIBLE);
    }
}
