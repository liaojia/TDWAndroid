package com.tdw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 画虚线组件
 */
public class DashedLine extends View {
public DashedLine(Context context, AttributeSet attrs) {  
        super(context, attrs);                      
    }  
  
    @SuppressLint("DrawAllocation")
	@Override  
    protected void onDraw(Canvas canvas) {  
        // TODO Auto-generated method stub  
        super.onDraw(canvas);          
        Paint paint = new Paint();  
        paint.setStyle(Paint.Style.STROKE);  
        paint.setColor(Color.GRAY);  
        paint.setStrokeWidth(3);//宽度
        Path path = new Path();       
        path.moveTo(0, 10);  
        path.lineTo(780,10);        
        PathEffect effects = new DashPathEffect(new float[]{5,5,5,5},1);//,绘制长度5的实线,再绘制长度5的空白,再绘制长度5的实线,再绘制长度5的空白,依次重复.1是偏移量,  
        paint.setPathEffect(effects);  
        canvas.drawPath(path, paint);  
    } 
}