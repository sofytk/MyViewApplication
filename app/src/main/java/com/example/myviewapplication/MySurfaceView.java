package com.example.myviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private int FPS = 100;
    private DrawThread drawThread;
    private MyCircle circle;
    private float xCircle;
    private float yCircle;
    private Paint paint;
    private float radius;


    public MySurfaceView(Context context) {
        super(context);
        drawThread = new DrawThread();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        circle = new MyCircle(200, 600, 20, 20);
        paint = new Paint();
        this.surfaceHolder = holder;
      drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    public boolean onTouchEvent(MotionEvent event) {
        circle.setY(event.getY());
        circle.setX(event.getX());
        update();
        return false;
    }

    void update () {
            circle.update(1000);
        }


    class DrawThread extends Thread {

        private volatile boolean running = true;
        Canvas canvas;

        @Override
        public void run() {
            while (running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    canvas.drawColor(Color.BLACK);
                    paint.setColor(Color.RED);
                    canvas.drawCircle(circle.getX(), circle.getY(), 50, paint);
                    Log.d("T_T", "update");
                } catch (Exception e) {
                    Log.e("DSS", e.getMessage());

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}

