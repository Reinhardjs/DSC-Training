package com.reinhardjs.dsc_training.Training2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.List;

public class ScrollViewBehavior extends CoordinatorLayout.Behavior {

    public ScrollViewBehavior(){
        super();
    }

    public ScrollViewBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    float dY;
    int lastAction;

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent event) {

        if(child instanceof ScrollView && event.getActionMasked() == MotionEvent.ACTION_DOWN){

            ScrollView lv = (ScrollView ) child;

//            int top = lv.getTop();

//            if(top - txtTop > 450){
//                lv.setTop(lv.getTop() - 550);
//            }else if(top - txtTop < 550){
//                lv.setTop(lv.getTop() +  550);
//            }

            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dY = lv.getY() - event.getRawY();
                    lastAction = MotionEvent.ACTION_DOWN;
                    break;

                case MotionEvent.ACTION_MOVE:
                    lv.setY(event.getRawY() + dY);
                    lastAction = MotionEvent.ACTION_MOVE;
                    break;

                case MotionEvent.ACTION_UP:
                    break;

                default:
                    return false;
            }

        }

        return true;
    }
}