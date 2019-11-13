package com.cookandroid.chaper08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputArea;
    Button write, read;
    TextView outputArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputArea = (EditText) findViewById(R.id.inputArea);
        write = (Button) findViewById(R.id.write);
        read = (Button) findViewById(R.id.read);
        outputArea = (TextView) findViewById(R.id.outputArea);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //파일 입출력을 위해서 fileinput(output)stream
                //이라는 클래스를 이용합니다.
                try {
                    FileOutputStream outFs =
                            openFileOutput("file.txt", MODE_PRIVATE);
                    if (inputArea.getText().toString() == "") {
                        Toast.makeText(MainActivity.this, "입력된 내용이 없습니다.", Toast.LENGTH_LONG);
                        return;
                    }
                    String str = inputArea.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                } catch (FileNotFoundException e) {
                    //file not fount 예외 처리 부분
                } catch (IOException e) {
                    //파일입출력에 대한 예외처리 부분;
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //한번에 읽어들일 수 있는 최대한의 바이트수 지정
                    //작은 바이트 단위로 나눠 읽어들일 경우
                    //예상치 못한 글자 깨짐이 발생할 수 있다.(한글)
                    FileInputStream inFs
                            = openFileInput("file.txt");
                    //버퍼가 처리하는 방식과 비슷
                    //한 번에 읽어들일 수 있는 최대한 byte수 지정
                    byte[] txt = new byte[3000];
                    inFs.read(txt);

                    String str = new String(txt);
                    outputArea.setText(str);
                    inFs.close();
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        });
    }
}
