package com.cookandroid.diaryapp21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // 위젯의 배치 순서대로 변수 선언
    EditText year, month, day;
    Button writeMode, readMode;

    // inputDiary, writeOrInsert는 writeView에 속한 위젯들
    LinearLayout writeView;
    EditText inputDiary;
    Button writeOrInsert;

    // outputDiary는 readView에 속한 위젯들
    LinearLayout readView;
    TextView outputDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        year = (EditText)findViewById(R.id.year);
        month = (EditText)findViewById(R.id.month);
        day = (EditText)findViewById(R.id.day);

        writeMode = (Button)findViewById(R.id.writeMode);
        readMode = (Button)findViewById(R.id.readMode);

        writeView = (LinearLayout)findViewById(R.id.writeView);
        inputDiary = (EditText)findViewById(R.id.inputDiary);
        writeOrInsert = (Button)findViewById(R.id.writeOrInsert);

        readView = (LinearLayout)findViewById(R.id.readView);
        outputDiary = (TextView)findViewById(R.id.outputDiary);

        writeOrInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //파일 입출력을 위해서 fileinput(output)stream
                //이라는 클래스를 이용합니다.
                try {
                    String datedate = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";
                    FileOutputStream outFs =
                            openFileOutput(datedate , MODE_PRIVATE);
                    if (inputDiary.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "입력된 내용이 없습니다.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    String str = inputDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "2", Toast.LENGTH_LONG).show();
                }
            }
        });


        writeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if(!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    // writeView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.VISIBLE);
                    readView.setVisibility(View.GONE);

                    try {
                        //한번에 읽어들일 수 있는 최대한의 바이트수 지정
                        //작은 바이트 단위로 나눠 읽어들일 경우
                        //예상치 못한 글자 깨짐이 발생할 수 있다.(한글)
                        String datedate = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";
                        FileInputStream inFs
                                = openFileInput(datedate);
                        //버퍼가 처리하는 방식과 비슷
                        //한 번에 읽어들일 수 있는 최대한 byte수 지정
                        byte[] txt = new byte[3000];
                        inFs.read(txt);
                        String str = new String(txt);
                        inFs.close();
                        inputDiary.setText(str);

                    } catch (FileNotFoundException e) {
                        inputDiary.setText("");
                    } catch (IOException e) {
                    }
                }
            }
        });

        readMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if(!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    // readView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.GONE);
                    readView.setVisibility(View.VISIBLE);

                    try {
                        //한번에 읽어들일 수 있는 최대한의 바이트수 지정
                        //작은 바이트 단위로 나눠 읽어들일 경우
                        //예상치 못한 글자 깨짐이 발생할 수 있다.(한글)
                        String datedate = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";
                        FileInputStream inFs
                                = openFileInput(datedate);
                        //버퍼가 처리하는 방식과 비슷
                        //한 번에 읽어들일 수 있는 최대한 byte수 지정
                        byte[] txt = new byte[3000];
                        inFs.read(txt);
                        String str = new String(txt);
                        outputDiary.setText(str);
                        inFs.close();
                    } catch (FileNotFoundException e) {
                        outputDiary.setText("");
                    } catch (IOException e) {
                    }
                }
            }
        });
    }
    boolean isInputDate(){
        // 년, 월, 일 EditText가 모두 작성된 경우에만 true 반환
        boolean a = year.getText().toString().equals("");
        boolean b = month.getText().toString().equals("");
        boolean c = day.getText().toString().equals("");
        return (!a) && (!b) && (!c);
    }
}