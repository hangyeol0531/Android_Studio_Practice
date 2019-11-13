package com.cookandroid.a191108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.bt1);
        et1 = (EditText)findViewById(R.id.et1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(et1.getText().toString());
                Intent intent = new Intent
                        (getApplicationContext(), SecondActivity.class);
                intent.putExtra("aaaaa", n1);
                startActivityForResult(intent, 0);
            }
        });
    }
}
