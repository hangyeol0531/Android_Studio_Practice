package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewEx extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        setTitle("그리드뷰 테스트");

        final GridView gv = (GridView)findViewById(R.id.gridView);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    // 1. BaseAdapter의 상속을 받는 어댑터를 정의.
    public class MyGridAdapter extends BaseAdapter {
        // 2. 컨택스트 변수를 선언하고, this 컨택스트를 생성자에서 받아옴.
        // 다른 메소드에서 context 변수를 사용하기 위함.
        Context ctx;
        public MyGridAdapter(Context c) {
            ctx = c;
        }

        // 3. Ctrl + i 를 눌러서
        // 추상메소드들의 기본 형태를 자동 완성

        // 4. getCount() - 그리드뷰에 보일 이미지의 갯수 반환 - 와
        // getView() - 영화 포스터를 각 그리드뷰 칸마다 이미지로 보여줌 - 메소드를
        // 필요성에 맞게 수정
        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        // 4-1. 영화 포스터들의 고유값을 배열 형태로 처리
        Integer posterId[] = {R.drawable.movie_image1, R.drawable.movie_image2,
                R.drawable.movie_image3, R.drawable.movie_image4,
                R.drawable.movie_image5, R.drawable.movie_image6,
                R.drawable.movie_image7, R.drawable.movie_image8,
                R.drawable.movie_image9, R.drawable.movie_image10,
                R.drawable.movie_image1, R.drawable.movie_image2,
                R.drawable.movie_image3, R.drawable.movie_image4,
                R.drawable.movie_image5, R.drawable.movie_image6,
                R.drawable.movie_image7, R.drawable.movie_image8,
                R.drawable.movie_image9, R.drawable.movie_image10,
                R.drawable.movie_image1, R.drawable.movie_image2,
                R.drawable.movie_image3, R.drawable.movie_image4,
                R.drawable.movie_image5, R.drawable.movie_image6,
                R.drawable.movie_image7, R.drawable.movie_image8,
                R.drawable.movie_image9, R.drawable.movie_image10};

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // i = list의 포지션. 아래의 내용들이 getCount()만큼 반복된다고 생각하셈.
            ImageView iv = new ImageView(ctx);
            iv.setLayoutParams(new GridView.LayoutParams(200,300));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(5,5,5,5);

            iv.setImageResource(posterId[i]);

            final int pos = i;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),
                            "text:" + GridViewEx.this.toString() +
                                    "/ and: " + getApplicationContext().toString(),
                            Toast.LENGTH_LONG).show();
                    View dialogView = (View)View.inflate
                            (GridViewEx.this,
                            R.layout.grid_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(GridViewEx.this);
                    ImageView bigPoster = (ImageView)dialogView.findViewById(R.id.bigPoster);
                    bigPoster.setImageResource(posterId[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return iv;
        }
    }
}