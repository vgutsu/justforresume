package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.SeatWrapper;
import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.activities.MovieDetailActivity;
import com.cinecentre.cinecentrecinema.customviews.CinemaChooseSeatView;
import com.cinecentre.cinecentrecinema.presenters.SeatsPresenter;
import com.cinecentre.cinecentrecinema.presenters.SeatsView;
import com.cinecentre.cinecentrecinema.rest.model.Order;
import com.cinecentre.cinecentrecinema.rest.response.SeatsData;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;
import com.cinecentre.seats.hall.HallScheme;
import com.cinecentre.seats.hall.MaxSeatsClickListener;
import com.cinecentre.seats.hall.Seat;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by victg on 28.02.2017.
 */
public class BuySeatFragment extends BaseFragment<SeatsView, SeatsPresenter> implements SeatsView, MaxSeatsClickListener {

    @BindView(R.id.cinema_choose_seats)
    CinemaChooseSeatView chooseSeatView;
    @BindView(R.id.film_title)
    TextView film_title;
    @BindView(R.id.date_and_where_title)
    TextView date_and_where_title;
    @BindView(R.id.totalPrice)
    TextView totalPrice;
    @BindView(R.id.seatNames)
    TextView seatNames;
    private int maxPerTrans = 5;
    private double ticketRate;


    @Override
    public SeatsPresenter createPresenter() {
        return new SeatsPresenter(getContext());
    }

    @Override
    public int getFragmentId() {
        return ID_BUY_SEATS;
    }

    @Override
    protected int title() {
        return R.string.buytickets;
    }

    @Override
    protected int layout() {
        return R.layout.layout_buy_ticket;
    }


    public static BaseFragment newInstance(Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseActivity.EXTRA_SERIALIZABLE, serializable);
        BuySeatFragment fragment = new BuySeatFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TickettypesData data = (TickettypesData) getArguments().getSerializable(MovieDetailActivity.EXTRA_SERIALIZABLE);
        film_title.setText(data.getMovieInfo().getMovieName());
        date_and_where_title.setText(data.getWholeShowTimesString() + " - " + data.getCinemaName());
        maxPerTrans = data.getSeatingAreaInfo().getMaxTicketsPerTrans();
        chooseSeatView.setMaxSeatsClickListener(maxPerTrans, this);
        ticketRate = data.getCurrentTicketType().getTicketRate();

        getPresenter().getSeats(data.getCinemaId(), data.getScheduleId());
    }

    private void setSeatDescription() {
        List<HallScheme.SeatType> objects = new LinkedList<>();
        objects.add(new HallScheme.SeatType(HallScheme.SeatStatus.FREE, ContextCompat.getColor(getContext(), android.R.color.transparent), ContextCompat.getColor(getContext(), R.color.color_border_background_seats)));
        objects.add(new HallScheme.SeatType(HallScheme.SeatStatus.BUSY, ContextCompat.getColor(getContext(), R.color.color_occupied_seats)));
        objects.add(new HallScheme.SeatType(HallScheme.SeatStatus.OTHER, ContextCompat.getColor(getContext(), R.color.color_wheel_seats)));
        objects.add(new HallScheme.SeatType(HallScheme.SeatStatus.CHOSEN, ContextCompat.getColor(getContext(), R.color.color_chosen_seats)));
        chooseSeatView.setSeatDescription(objects);
    }


    @Override
    public void onMaxSeatsReached() {
        showMessage(getString(R.string.maxseats));
    }

    @Override
    public void onGetSelectedSeatList(List<Seat> seatList) {
        int quantity = seatList.size();
        totalPrice.setText("Total: R " + String.valueOf(quantity * ticketRate));
        seatNames.setText(TextUtils.join(" | ", seatList));
    }

    @Override
    public void onSetData(SeatsData data) {
        Seat[][] seats = SeatWrapper.wrap(data);
        chooseSeatView.setSeats(seats);
        setSeatDescription();
    }

    @Override
    public void onShowMessage(String error) {
        showMessage(error);
    }

    @OnClick(R.id.button_buy_ticket)
    void buyTicket() {
        pushFragment(ConfirmBookingFragment.newInstance(new Order()), true);
    }
}