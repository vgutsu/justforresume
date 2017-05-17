package com.cinecentre.cinecentrecinema.customviews;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cinecentre.cinecentrecinema.R;


/**
 * Created by victg on 09.03.2017.
 */

public class TicketView extends LinearLayout {

    public TicketView(Context context) {
        super(context);

        init();
    }

    public TicketView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TicketView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TicketView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    void init() {
        inflate(getContext(), R.layout.layout_ticketview, this);
        final Dialog nagDialog = new Dialog(getContext(), android.R.style.Theme_Translucent_NoTitleBar);
        nagDialog.setCancelable(true);
        nagDialog.setContentView(R.layout.preview_image);
        final ImageView qr_code_image = (ImageView) findViewById(R.id.qr_code_image);
        findViewById(R.id.qr_code_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView ivPreview = (ImageView) nagDialog.findViewById(R.id.iv_preview_image);
                ivPreview.setImageDrawable(qr_code_image.getDrawable());
                nagDialog.show();
            }
        });
    }
}

