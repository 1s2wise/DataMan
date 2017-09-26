package com.example.android.dataman;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etx;
    Button benc, bdec, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etx = (EditText) findViewById(R.id.input);
        benc = (Button) findViewById(R.id.enc);
        bdec = (Button) findViewById(R.id.dec);
        reset = (Button) findViewById(R.id.rst);



        benc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String readtext = etx.getText().toString();



                char[] ch = readtext.toCharArray();
                int i=0,j;
                char temp;
                for(i=0;i<ch.length;i++){
                    temp = ch[i];
                    j=(int)temp;
                    j+=3;
                    ch[i]=(char)j;
                }
                String encTxt = String.valueOf(ch);


                Context context = MainActivity.this;
                Class destination = ChildActivity.class;
                Intent startChildActivity = new Intent(context,destination);
                startChildActivity.putExtra(Intent.EXTRA_TEXT,encTxt);
                startActivity(startChildActivity);
            }
        });
        bdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String readtext = etx.getText().toString();

                char[] ch = readtext.toCharArray();
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
                    else{

                    }
                String encTxt = String.valueOf(ch);
                encTxt=encTxt.substring(2);

                Context ctx2 = MainActivity.this;
                Class dest = ChildActivity.class;
                Intent startChildAct = new Intent(ctx2,dest);
                startChildAct.putExtra(Intent.EXTRA_TEXT,encTxt);
                startActivity(startChildAct);


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etx.setText("");
            }
        });

    }

    }







