package com.gxb.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by g on 2017/8/30.
 */

//后台更改
public class MyTextView extends View {
    private String drawText="";
    private int textColor;
    private float textSize;

    public MyTextView(Context context) {
        super(context);
        initAttrs(null);
    }
    //前端更改
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    private void initAttrs(@Nullable AttributeSet attrs){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
        drawText= typedArray.getString(R.styleable.MyTextView_text);
        textColor=typedArray.getColor(R.styleable.MyTextView_textColor,0xffffff);
        textSize=typedArray.getDimension(R.styleable.MyTextView_textSize,20);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        canvas.drawText(drawText,10,100,paint);
    }
}
