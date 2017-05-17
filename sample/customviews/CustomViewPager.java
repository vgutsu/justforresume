package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.cinecentre.cinecentrecinema.R;

/**
 * Created by victg on 09.03.2017.
 */
public class CustomViewPager extends ViewPager {
    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_standart);

    public CustomViewPager(Context context) {
        super(context);
        init(dimensionPixelSize);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(dimensionPixelSize);
    }

    public void init(int dimensionPixelSize) {
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setClipToPadding(false);
        setPageMargin(dimensionPixelSize / 2);
    }
}
