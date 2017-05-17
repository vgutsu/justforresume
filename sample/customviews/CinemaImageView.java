package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.util.AttributeSet;

public class CinemaImageView extends CustomImageView {

    public CinemaImageView(Context context) {
        super(context);
    }

    public CinemaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CinemaImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = (int) (width / 1.4);
        setMeasuredDimension(width, height);
    }
}