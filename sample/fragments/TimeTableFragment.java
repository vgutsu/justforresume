package com.cinecentre.cinecentrecinema.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.IntentStarter;
import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.activities.MovieDetailActivity;
import com.cinecentre.cinecentrecinema.adapters.BaseSectionedRecyclerViewAdapter;
import com.cinecentre.cinecentrecinema.adapters.ListAdapter;
import com.cinecentre.cinecentrecinema.adapters.ShowCinemaTimeTableAdapter;
import com.cinecentre.cinecentrecinema.adapters.ShowMovieTimeTableAdapter;
import com.cinecentre.cinecentrecinema.interfaces.ScheduleClickCallback;
import com.cinecentre.cinecentrecinema.presenters.TimeTablePresenter;
import com.cinecentre.cinecentrecinema.presenters.TimeTableTicketView;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;
import com.cinecentre.cinecentrecinema.rest.model.TicketType;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;


/**
 * Created by victg on 11.02.2017.
 */
public class TimeTableFragment extends BaseFragment<TimeTableTicketView, TimeTablePresenter>
        implements TimeTableTicketView, ScheduleClickCallback, DialogInterface.OnClickListener {
    public static final String EXTRA_MOVIE_DATE = "EXTRA_MOVIE_DATE";
    @BindView(R.id.recycleview)
    RecyclerView recyclerView;
    private BaseSectionedRecyclerViewAdapter timeTableAdapter;

    private ListAdapter<TicketType> ticketTypeAdapter;
    private AlertDialog alertDialog;

    @Override
    public int getFragmentId() {
        return NONE;
    }

    @Override
    protected int title() {
        return NONE;
    }

    @Override
    protected int layout() {
        return R.layout.layout_time_table;
    }

    public static BaseFragment newInstance(Serializable serializable, MovieDate date) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_MOVIE_DATE, date);
        bundle.putSerializable(MovieDetailActivity.EXTRA_SERIALIZABLE, serializable);
        TimeTableFragment timeTableFragment = new TimeTableFragment();
        timeTableFragment.setArguments(bundle);
        return timeTableFragment;
    }

    @Override
    public TimeTablePresenter createPresenter() {
        return new TimeTablePresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieDate date = (MovieDate) getArguments().getSerializable(EXTRA_MOVIE_DATE);
        Serializable serializable = getArguments().getSerializable(MovieDetailActivity.EXTRA_SERIALIZABLE);

        if (serializable instanceof Film) timeTableAdapter = new ShowMovieTimeTableAdapter();
        if (serializable instanceof Cinema) timeTableAdapter = new ShowCinemaTimeTableAdapter();

        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        timeTableAdapter.setLayoutManager(manager);
        timeTableAdapter.setOnScheduleButtonClickListener(this);
        recyclerView.setAdapter(timeTableAdapter);
        recyclerView.setLayoutManager(manager);


        ticketTypeAdapter = new ListAdapter<>(getContext());
        TextView dialogTitle = (TextView) View.inflate(getContext(), R.layout.custom_dialog_title, null);
        dialogTitle.setText(R.string.select_ticket_type);
        alertDialog = new AlertDialog.Builder(getContext())
                .setCustomTitle(dialogTitle)
                .setAdapter(ticketTypeAdapter, TimeTableFragment.this)
                .create();

        getPresenter().setSerializeble(serializable);
        getPresenter().updateShowTimes(date);
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        getPresenter().setTicketTypeData(ticketTypeAdapter.getItem(i));
    }


    @Override
    public void onSetData(ShowTimesData data) {
        timeTableAdapter.setData(data);
    }

    @Override
    public void onShowTicketList(List<TicketType> list) {
        ticketTypeAdapter.clear();
        ticketTypeAdapter.addAll(list);
        ticketTypeAdapter.notifyDataSetChanged();
        alertDialog.show();
    }

    @Override
    public void onContinue(TickettypesData data) {
        IntentStarter.navigateBookingFragmentActivity(getContext(), data);
    }


    @Override
    public void onShowMessage(String error) {
        showMessage(error);
    }


    @Override
    public void onScheduleClick(Schedule schedule, Cinema cinema) {
        getPresenter().getTicketTypeData(cinema, schedule);
    }
}
