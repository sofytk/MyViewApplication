package com.example.myviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyCircle {
    private float x, y;
    int radius = 50;
    Paint paint = new Paint();

    private double velocityX;
    private double velocityY;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }


    public MyCircle(float x, float y, double velocityX, double velocityY) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    void draw(Canvas canvas, float x, float y) {
        paint.setColor(Color.RED);
        canvas.drawCircle(x, y, radius, paint);
    }

    protected void update(int ms) {
        x = (float) (x + velocityX * ms / 1000.0);
        y = (float) (y + velocityY * ms / 1000.0);
        Log.d("FFF", "updaterrr");
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
