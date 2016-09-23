package com.may.recycledemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 2016/9/22.
 */
public class MyRecyclerView extends RecyclerView {
    private View mCurrentView;
    private OnItemScrollChangeListener mItemScrollChangeListener;

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }

    /**
     * 滚动时回调的接口
     */
    public void setOnItemScrollChangeListener(
            OnItemScrollChangeListener mItemScrollChangeListener) {
        this.mItemScrollChangeListener = mItemScrollChangeListener;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mItemScrollChangeListener != null) {
            mItemScrollChangeListener.onChange(mCurrentView,
                    getChildPosition(mCurrentView));

        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//        if (e.getAction() == MotionEvent.ACTION_MOVE) {
//            mCurrentView = getChildAt(0);
//            // Log.e("TAG", getChildPosition(getChildAt(0)) + "");
//            if (mItemScrollChangeListener != null) {
//                mItemScrollChangeListener.onChange(mCurrentView,
//                        getChildPosition(mCurrentView));
//            }
//        }
//        return super.onTouchEvent(e);
//    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        View newView = getChildAt(0);

        if (mItemScrollChangeListener != null)
        {
            if (newView != null && newView != mCurrentView)
            {
                mCurrentView = newView ;
                mItemScrollChangeListener.onChange(mCurrentView,
                        getChildPosition(mCurrentView));

            }
        }
    }
}
