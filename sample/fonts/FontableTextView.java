package com.cinecentre.cinecentrecinema.fonts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by victg on 02.02.2017.
 */

public class FontableTextView extends TextView {
    public FontableTextView(Context context) {
        this(context, null);
    }

    public FontableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public FontableTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    void init(AttributeSet attrs) {
        CustomFontHelper.setCustomFont(this, getContext(), attrs);
    }
}
