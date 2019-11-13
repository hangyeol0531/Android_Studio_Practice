package com.cookandroid.muksijuckintent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button telBtn, webBtn, mapBtn, cameraBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telBtn = (Button)findViewById(R.id.telBtn);
        webBtn = (Button)findViewById(R.id.webBtn);
        mapBtn = (Button)findViewById(R.id.mapBtn);
        cameraBtn = (Button)findViewById(R.id.cameraBtn);

        telBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //묵시적(암시적)인텐트를 사용
                //Intent intent = new Intent(getApllication)
                // ㄴ 이건 명시적 인텐트 사용 방식

                Intent telIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0629496881"));
                startActivity(telIntent);
            }
        });

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webUri = Uri.parse("https://www.gsm.hs.kr");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapUri = Uri.parse("http://maps.google.com/maps?q="+35.1433977+","+126.7988363);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(mapIntent);
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(cameraIntent);
            }
        });
    }
}
