package com.bwie.zhoukaoa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/9 13:37
 */


public class JuXing extends View {

    private Paint paint;
    private String str="黄色";


    public JuXing(Context context) {
        super(context);


    }
    public JuXing(Context context, AttributeSet attrs) {
        super(context, attrs);


    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (str.equals("#FFFF00")){
            paint.setColor(Color.RED);
        }else {
            paint.setColor(Color.YELLOW);
        }
        canvas.drawRect(150,200,450,500,paint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initData();
    }
    private void initData() {
        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);


    }
    public void SetColor(String st){
        this.str=st;
        postInvalidate();

    }



}
