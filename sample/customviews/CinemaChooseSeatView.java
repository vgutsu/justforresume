package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.adapters.DescriptionAdapter;
import com.cinecentre.seats.hall.HallScheme;
import com.cinecentre.seats.hall.MaxSeatsClickListener;
import com.cinecentre.seats.hall.Seat;
import com.cinecentre.seats.hall.SeatListener;
import com.cinecentre.seats.hall.ZoomableImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victg on 02.03.2017.
 */

public class CinemaChooseSeatView extends LinearLayout {
    @BindView(R.id.zoomable_image)
    ZoomableImageView imageView;
    @BindView(R.id.seat_view)
    View seat_view;

    @BindView(R.id.horizontal_recyclerview)
    RecyclerView horizontal_recyclerview;

    private HallScheme scheme;
    private DescriptionAdapter horizontalAdapter;

    public CinemaChooseSeatView(Context context) {
        super(context);
        init();
    }

    public CinemaChooseSeatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CinemaChooseSeatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CinemaChooseSeatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_cinema_choose_seat, this);
        ButterKnife.bind(this);
        scheme = new HallScheme(getContext());
        scheme.setTextSize(getResources().getDimensionPixelSize(R.dimen.seat_text_size));
        scheme.setSeatWidth(getResources().getDimensionPixelSize(R.dimen.seat_width));
        scheme.setSeatGap(getResources().getDimensionPixelSize(R.dimen.seat_gap));
        scheme.setCornerSeatRadius(getResources().getDimensionPixelSize(R.dimen.radius));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        horizontalAdapter = new DescriptionAdapter();
        horizontal_recyclerview.setLayoutManager(layoutManager);
        horizontal_recyclerview.setAdapter(horizontalAdapter);
        horizontal_recyclerview.setNestedScrollingEnabled(false);

        seat_view.setAlpha(0.0f);
    }

    public void setSeats(Seat[][] seats) {
        scheme.setSeats(seats);
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int seatWidth = -getResources().getDimensionPixelSize(R.dimen.seat_gap) + screenWidth / seats[0].length;

        scheme.setSeatWidth(seatWidth);
        scheme.setTextSize(seatWidth / 2);
        scheme.draw(imageView);
        seat_view.animate().setDuration(500).alpha(1.0f);
    }

    public void setSeatDescription(List<HallScheme.SeatType> list) {
        horizontalAdapter.setList(list);
    }

    public void setMaxSeatsClickListener(int max, final MaxSeatsClickListener listener) {
        setMaxSeats(max);
        if (scheme != null) {
            scheme.setMaxSeatsClickListener(new MaxSeatsClickListener() {
                @Override
                public void onMaxSeatsReached() {
                    if (listener != null) listener.onMaxSeatsReached();
                }

                @Override
                public void onGetSelectedSeatList(List list) {
                    if (listener != null) listener.onGetSelectedSeatList(list);
                    if (horizontalAdapter != null) horizontalAdapter.setSelectedSeats(list.size());
                }
            });
        }
    }

    public void setSeatsClickListener(SeatListener listener) {
        if (scheme != null) {
            scheme.setSeatListener(listener);
        }
    }

    public void setMaxSeats(int max) {
        scheme.setMaxSelectedSeats(max);
    }


    public void setTextColor(int chosenSeatTextColor) {
        this.scheme.setTextColor(chosenSeatTextColor);
    }
}
