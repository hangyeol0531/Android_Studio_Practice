package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        setTitle("그리드뷰 테스트");

        final GridView gv = (GridView)findViewById(R.id.gridView);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter((gridAdapter));
    }

    //1.onCreate{} 바깥쪽에 새로운 클래스를 생성
    //BasAdapter 클래스를 상속(extends) 받는
    public class MyGridAdapter extends BaseAdapter{
        // 활용하고픈 생성자를 명시함
        Context ctx;
        public MyGridAdapter(Context c){
            ctx = c;
        }
        //2. Ctrl + i를 눌러서 ㅜ상메소드의 기본 형태를 명시
        //3. 그 중에 필요한 getCount()와
        //get View() 메소드만 재가공하여 사용
        //4.그리드뷰를 포함시킬 이미지들을 정의
        Integer posterid[] = {R.drawable.movie_image1, R.drawable.movie_image2, R.drawable.movie_image3, R.drawable.movie_image4, R.drawable.movie_image5
        , R.drawable.movie_image6, R.drawable.movie_image7, R.drawable.movie_image8, R.drawable.movie_image9, R.drawable.movie_image10};
        @Override
        public int getCount() {
            //posterid 변수의 길이만큼 (아마10이 반환)
            return posterid.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //6. 영화 포스터를 각 그리드뷰 칸마다 이미지로 보여주는 메소드
        // getView()가 getCount()에서의 넘겨받은 값만큼 반복
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //get View()의 int i <- 포지션을 가리킴
            ImageView iv = new ImageView(ctx);
            iv.setLayoutParams(new GridView.LayoutParams(200, 300));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(5,5,5,5);
            iv.setImageResource(posterid[i]);
            return null;
        }
    }
}
