package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.util.AttributeSet;

public class MovieImageView extends CustomImageView {
    public MovieImageView(Context context) {
        super(context);
    }

    public MovieImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MovieImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = (int) (1.5 * width);
        setMeasuredDimension(width, height);
    }
}