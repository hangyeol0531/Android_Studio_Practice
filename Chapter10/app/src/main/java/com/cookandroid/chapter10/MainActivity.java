package com.cookandroid.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정답률 45%를 자랑하는 마의 2번 문제");

        final int voteCount[] = new int[5];
        for(int i = 0; i < voteCount.length; i++)
            voteCount[i] = 0;

        Button btn[] = new Button[5];
        Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5};
        Button resultButton; // 결과보기; 버튼 (for문 처리 x)

        for(int i = 0; i < btnId.length; i++){
            final int index; //nner 클래스(내부클래스)에서의 접근
            index = i; // 인덱스 접근을 위해 필수적임!
            btn[index] = (Button)findViewById(btnId[index]);
            btn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            (index + 1) + "번 찍음",
                            Toast.LENGTH_SHORT).show();
                        }
            });
        }
        resultButton = (Button)findViewById(R.id.gotoResultActivity);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivite.class);
                // 액티비티간 데이터를 주고받기 위해 사용하는 메소드
                // putExtra(); 에다가 박스포장 해서 넘겨줄 수 있다.
                    intent.putExtra("Counting", voteCount/*int배열*/);
                startActivity(intent);
            }
        });
    }
}
//public class MainActivity extends AppCompatActivity {
//
//    Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btn = (Button)findViewById(R.id.gotosecondActivity);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //새로운 액티비티를 띄워주기 위한 코드들....
//                // Intent라는 걸 활용 - 4대 컴포넌트들
//                // 액티비티 서비스 콘텐트프로바이더, 브로드리비서
//                // 이 서로 데이터를 주고 받기 위해 사용하는 메세지 객체
//                //1. getApplicationContext();
//                // Contect = 어떤 Acitivtty 나 Application인지를
//                // '구별' 하는 정보
//                Intent intent = new Intent(
//                        getApplicationContext(),
//                        SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}
