package com.cookandroid.a191108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button bt2;
    EditText et2;
    TextView minnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        bt2 = (Button)findViewById(R.id.next2);
        et2 = (EditText)findViewById(R.id.et2);
        minnum = findViewById(R.id.minnum);

        Intent inIntent = getIntent();
        final int fnum = inIntent.getIntExtra("aaaaa", 0);
        minnum.setText("이전에 받아온 값  " + fnum);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(et2.getText().toString());
                Intent intent = new Intent
                        (getApplicationContext(), ThirdActivity.class);
                intent.putExtra("firstnum", fnum);
                intent.putExtra("secondnum", n1);
                startActivityForResult(intent, 0);
            }
        });


    }
}
