package com.example.buscardzz.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;


public class MyTextView extends TextView {


    private Paint textPaint;
    private float myPadding;

    public MyTextView(Context context) {
        super(context);
        textPaint = getPaint();
//        textPaint.setTypeface(Typeface.create("宋体", Typeface.BOLD));
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        textPaint = getPaint();
//        textPaint.setTypeface(Typeface.create("宋体", Typeface.BOLD));
    }
    public void setTextColor(int color){
        if(textPaint!=null){
            textPaint.setColor(color);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        int centerX = getWidth() / 2;
        int startX = (int) (centerX - (textPaint.measureText(text.substring(0, 1))) / 2);

        float a = textPaint.ascent();
        float d = textPaint.descent();
        float textH = d - a+4;
        float textH1 = -a;
        if (getHeight() - textH * text.length() > 0&&text.length()>1) {
            myPadding = (getHeight() - textH * text.length()) / (text.length()-1);
        }
        for (int i=0;i<text.length();i++) {
            canvas.drawText(text.substring(i,i+1),startX, textH1 +i*(textH+myPadding),textPaint);
        }
    }
}
