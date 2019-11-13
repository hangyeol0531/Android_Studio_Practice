package com.cookandroid.chapter10;

// 새로운 액티비티를 사용하기 위해서는
//1.XML 코드가 필요하다.
//2. jAVA 클래스가 필요 (액티비티 활성화)

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = (Button)findViewById(R.id.finishbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 직접 작성
            }
        });
    }
}
