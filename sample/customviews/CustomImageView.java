package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;


public class CustomImageView extends ImageView {
    private Picasso picasso;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();

    }

    void init() {
        picasso = Picasso.with(getContext());
    }

    public void setImageUrl(String imageUrl) {
        setImageUrl(imageUrl, 0, null);
    }

    public void setImageUrl(String imageUrl, int holder) {
        setImageUrl(imageUrl, holder, null);
    }

    public void setImageUrl(final String imageUrl, Callback callback) {
        if (picasso == null) return;
        setImageUrl(imageUrl, 0, callback);
    }

    public void setImageUrl(final String imageUrl, int holder, Callback callback) {
        if (picasso == null) return;
        RequestCreator creator = picasso.load(imageUrl)
                .fit()
                .centerCrop();
        if (holder != 0) creator.placeholder(holder);
        creator.into(this, callback);
    }

    public void setImageResource(int source) {
        setImageResource(source, null);
    }

    public void setImageResource(int source, Callback callback) {
        if (picasso != null) picasso.load(source).into(this, callback);
    }
}