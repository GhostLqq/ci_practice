package com.example.custom_view.temp_control_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

public class TempControlView extends View {

    // 控件高度
    private int heigh;
    // 控件宽度
    private int width;
    // 刻度盘半径
    private int dialRadius;
    // 圆弧半径
    private int arcRadius;
    // 刻度高
    private int scaleHeigh = dp2px(10);
    // 刻度盘画笔
    private Paint dialPaint;
    // 圆弧画笔
    private Paint arcPaint;
    // 标题画笔
    private Paint titlePaint;
    // 温度标识画笔
    private Paint tempFlagPaint;
    // 旋转按钮画笔
    private Paint buttonPaint;
    // 温度显示画笔
    private Paint tempPaint;
    // 抗锯齿
    private PaintFlagsDrawFilter paintFlagsDrawFilter;
    // 四格代表温度1度
    private int angleRate = 4;
    // 最高温度
    private int maxTemp = 30;
    // 最低温度
    private int minTemp = 15;
    // 温度
    private int temperature = 15;
    // 每格的角度
    private float angleOne = (float) 270 / (maxTemp - minTemp) / angleRate;


    public TempControlView(Context context) {
        this(context, null);
    }

    public TempControlView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TempControlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // 初始化属性
    private void init() {
        dialPaint = new Paint();
        dialPaint.setAntiAlias(true);
        dialPaint.setStrokeWidth(dp2px(2));
        dialPaint.setStyle(Paint.Style.STROKE);

        arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        arcPaint.setColor(Color.parseColor("#3CB7EA"));
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(dp2px(2));

        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setColor(Color.parseColor("#3B434E"));
        titlePaint.setStyle(Paint.Style.STROKE);
        titlePaint.setTextSize(sp2px(25));

        tempFlagPaint = new Paint();
        tempFlagPaint.setAntiAlias(true);
        tempFlagPaint.setTextSize(dp2px(25));
        tempFlagPaint.setColor(Color.parseColor("#E4A07E"));
        tempFlagPaint.setStyle(Paint.Style.STROKE);

        buttonPaint = new Paint();

        paintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);

        tempPaint = new Paint();
        tempPaint.setAntiAlias(true);
        tempPaint.setTextSize(sp2px(60));
        tempPaint.setColor(Color.parseColor("#E27A3F"));
        tempPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 控件宽高
        width = heigh = Math.min(w, h);
        // 刻度盘半径
        dialRadius = width / 2 - dp2px(20);
        // 圆弧半径
        arcRadius = dialRadius - dp2px(20);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScale(canvas);
        drawArc(canvas);
        drawText(canvas);
        drawButton(canvas);
        drawTemp(canvas);
    }

    /**
     * 绘制刻度盘
     *
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        // 顺时针旋转135-2度
        canvas.rotate(133);
        // 未达到的温度
        dialPaint.setColor(Color.parseColor("#3CB7EA"));
        for (int i = angleRate * maxTemp; i > angleRate * temperature; i--) {
            canvas.drawLine(0, -dialRadius, 0, -dialRadius + scaleHeigh, dialPaint);
            canvas.rotate(-angleOne);
        }
        // 已经达到的问题
        dialPaint.setColor(Color.parseColor("#E37364"));
        canvas.restore();
    }

    private void drawArc(Canvas canvas) {

    }

    private void drawText(Canvas canvas) {

    }

    private void drawButton(Canvas canvas) {

    }

    private void drawTemp(Canvas canvas) {

    }

    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                getResources().getDisplayMetrics());
    }
}
