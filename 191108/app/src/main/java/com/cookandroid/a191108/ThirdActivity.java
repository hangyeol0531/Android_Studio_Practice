package com.cookandroid.a191108;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button bt3;
    TextView resultnum;
    Button back;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        resultnum = (TextView)findViewById(R.id.resultnum);
        bt3 = (Button)findViewById(R.id.from3back);
        back = (Button)findViewById(R.id.from3back);

        Intent inIntent = getIntent();
        final int num1= inIntent.getIntExtra("firstnum", 0);
        final int num2 = inIntent.getIntExtra("secondnum", 0);
        int n = 0;
        for(int i = num1; i <= num2; i++){
           n += i;
        }
        resultnum.setText(n);

    }
}
