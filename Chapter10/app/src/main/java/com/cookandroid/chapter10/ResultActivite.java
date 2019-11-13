package com.cookandroid.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivite extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("집계 결과를 보여주는 액티비티");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("Counting");

        TextView tv[] = new TextView[voteResult.length];
        Integer tvId[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};

        for(int i = 0;i < tvId.length; i++){
            tv[i] = (TextView)findViewById(tvId[i]);
            String str = String.valueOf(voteResult[i]);
            tv[i].setText(str);
        }
    }
}
