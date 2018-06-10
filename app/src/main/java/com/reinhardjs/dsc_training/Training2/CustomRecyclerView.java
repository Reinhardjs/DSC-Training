package com.reinhardjs.dsc_training.Training2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public class CustomRecyclerView extends RecyclerView {

    LinearLayout bottomFreeSpace;

    LinearLayoutManager linearLayoutManager;
    DisplayMetrics displayMetrics;
    float deviceHeight;
    float dY, lastY;

    public CustomRecyclerView(Context context){
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int style){
        super(context, attrs, style);
    }

    public int convertToDp(float pixel){
        float density = getResources().getDisplayMetrics().density;
        return (int) (pixel / density);
    }

    public int convertToDp(int pixel){
        float density = getResources().getDisplayMetrics().density;
        return (int) (pixel / density);
    }

    public void init(LinearLayoutManager linearLayoutManager, final LinearLayout bottomFreeSpace){
        this.bottomFreeSpace = bottomFreeSpace;

        displayMetrics = getResources().getDisplayMetrics();

        // Device height in dp
        deviceHeight = Math.round(displayMetrics.heightPixels / displayMetrics.density);
        this.linearLayoutManager = linearLayoutManager;

        // this.setY(bottomFreeSpace.getY()) returned 0.0
        // solved https://stackoverflow.com/questions/32400211/view-getx-and-gety-return-0-0-after-they-have-been-added-to-the-activity?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
        bottomFreeSpace.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Parent (relative layout)
                // udah selesai melakukan layout children nya
                CustomRecyclerView.this.setY(bottomFreeSpace.getY());

                // Jangan lupa untuk selalu menghapus listener
                // setelah selesai melakukan sesuatu
                bottomFreeSpace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                lastY = event.getRawY();
                dY = this.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                boolean isNotReachTop = convertToDp(event.getRawY()+dY) >= convertToDp(165.0f);
                boolean isNotBottomReach = convertToDp(event.getRawY()+dY) <= convertToDp(bottomFreeSpace.getY());

                boolean isDraggedUp = lastY-event.getRawY() > 0;
                boolean isDraggedDown = lastY-event.getRawY() < 0;

                int totalItemCount = linearLayoutManager.getItemCount();
                int lastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int firstCompletelyVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                boolean isOnTop = firstCompletelyVisibleItem == 0;

                if (isNotReachTop && isNotBottomReach){
                    if (isOnTop) {
                        this.setY(event.getRawY() + dY);
                        return true;
                    } else {
                        dY = this.getY() - event.getRawY();
                    }
                } else {
                    // Selalu ubah dY saat melewati batas atas dan bawah
                    // Jika tidak, maka pada saat mencapai batas bawah,
                    // recyclerview akan drag pada saat isNotBottomReach bernilai benar
                    dY = this.getY() - event.getRawY();

                    // Menghindari scrolling ke atas pada saat mencapai batas bawah
                    if (isDraggedUp && !isNotBottomReach){
                        return true;
                    }
                }

                lastY = event.getRawY();

                break;

            default:
                return false;
        }

        //Dispatch event for non-scroll actions, namely clicks!
        return super.dispatchTouchEvent(event);
    }

}
