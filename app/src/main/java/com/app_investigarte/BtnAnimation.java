package com.app_investigarte;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BtnAnimation extends androidx.appcompat.widget.AppCompatButton implements View.OnTouchListener {
    public BtnAnimation(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }

    public BtnAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);

    }

    public BtnAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        this.setOnTouchListener(this);

    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                view.setAlpha(0.7f);
                break;
            }
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP: {
                view.setAlpha(1.0f);
                break;
            }
        }
        return false;
    }
}


