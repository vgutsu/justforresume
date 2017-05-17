package com.cinecentre.cinecentrecinema.customviews.decorators;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;

public class RecycleViewMarginDecoration extends RecyclerView.ItemDecoration {
    private final int columns;
    private int margin;

    /**
     * constructor
     *
     * @param margin  desirable margin size in px between the views in the recyclerView
     * @param columns number of columns of the RecyclerView
     */
    public RecycleViewMarginDecoration(@IntRange(from = 0) int margin, @IntRange(from = 0) int columns) {
        this.margin = margin;
        this.columns = columns;

    }

    public RecycleViewMarginDecoration(Context context) {
        this.margin = context.getResources().getDimensionPixelSize(R.dimen.margin_standart);
        this.columns = 1;
    }

    /**
     * Set
     * different margins for the items inside the recyclerView: no top margin for the first row
     * and no left margin for the first column.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildLayoutPosition(view);
        //set right margin to all
        outRect.right = margin;
        //set bottom margin to all
        outRect.bottom = margin;
        //we only add top margin to the first row
        if (position < columns) {
            outRect.top = margin;
        }
        //add left margin only to the first column
        if (position % columns == 0) {
            outRect.left = margin;
        }
    }
}