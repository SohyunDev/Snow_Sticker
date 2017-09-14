package com.example.snow_sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    protected class Point{
        private int x,y;
        Point(int x1, int y1){
            this.x = x1;
            this.y = y1;
        }

        public int get_x(){
            return x;
        }
        public int get_y(){
            return y;
        }
        public void set_pt(int x1, int y1){
            this.x=x1;
            this.y=y1;
        }
    }



    protected class MyView extends View {
        int x=0, y=0;
        Bitmap mybitmap;
        ArrayList<Point> points =new ArrayList<Point>();

        public MyView(Context context){
            super(context);
            setBackgroundResource(R.drawable.dal);
            mybitmap = BitmapFactory.decodeResource(getResources(), R.drawable.peach);
            mybitmap = Bitmap.createScaledBitmap(mybitmap, mybitmap.getWidth()/2, mybitmap.getHeight()/2, true);
        }

        @Override
        protected void onDraw(Canvas canvas){

            for(int i = 0; i<points.size(); i++) {
                canvas.drawBitmap(mybitmap, points.get(i).get_x(), points.get(i).get_y(), null);
            }
        }


        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_UP){
                x = (int) event.getX();
                y = (int) event.getY();
                points.add(new Point(x,y));
                invalidate();
            }

            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}


