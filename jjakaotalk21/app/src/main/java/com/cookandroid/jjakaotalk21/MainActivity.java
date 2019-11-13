package com.cookandroid.jjakaotalk21;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout friend;
    TextView friendName, title;
    TextView sangme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend = findViewById(R.id.friend);
        friendName = findViewById(R.id.friendName);
        sangme = (TextView)findViewById(R.id.sangme);
        title = findViewById(R.id.title);

        registerForContextMenu(friend);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater mInf = getMenuInflater();

        mInf.inflate(R.menu.main_configure_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater contextMInf = getMenuInflater();
        if (v == friend) contextMInf.inflate(R.menu.user_configure_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        switch (item.getItemId()) {
            case R.id.favoriteOption:
                //커스텀한 대화상자를 만들어보기(xml 레리아웃 파일을 팝업처럼 띄우기)
                // sangmeLayout ~ inflating(뷰에 대한 객체화)
                final View sangmeView = (View)View.inflate(MainActivity.this,
                        R.layout.sangme, null);
                AlertDialog.Builder changeDialog =
                        new AlertDialog.Builder(MainActivity.this);
                changeDialog.setView(sangmeView);
                changeDialog.setNegativeButton("취소", null);
                changeDialog.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 우리가 덍겨오고 싶어하는 위젯 edittext
                        // sangme_acitivty ,-- 다른 액티비티에게서
                        EditText et = (EditText)sangmeView.findViewById(R.id.sangme);
                        sangme.setText(et.getText().toString());
                    }
                });
                changeDialog.show();

                return true;
            case R.id.deleteOption:
                // 팝업창처럼 사용 가능한 '대화상자'를 만들어보자.
                AlertDialog.Builder delDialog =
                        new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("대화상자의 이름");
                delDialog.setMessage("진짜로 나를 손절할꺼야? 8ㅅ8");
                delDialog.setNegativeButton("손절안함", null);
                delDialog.setPositiveButton("응 너 손절띠~", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //To-do
                        friend.setVisibility(View.GONE);
                    }
                });
                delDialog.show();
                return false;
        }
        return true;
    }
}