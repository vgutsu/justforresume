package com.cinecentre.cinecentrecinema.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.MovieShowTimesData;

import java.util.List;

public class ShowMovieTimeTableAdapter extends BaseSectionedRecyclerViewAdapter<MovieShowTimesData, ShowMovieTimeTableAdapter.MovieTimeTableHolder> {


    @Override
    public int getItemCount(int section) {
        int sectionItemCount = 0;
        ShowTimesData data = getData();
        if (data != null && data.getList() != null && data.getSchedulesMap() != null) {
            Cinema cinema = (Cinema) data.getList().get(section);
            sectionItemCount = data.getSchedulesMap().get(cinema.getCinemaId()).size(); // even sections get 4 items
        }
        return sectionItemCount;
    }

    @Override
    public void onBindHeaderViewHolder(MovieTimeTableHolder holder, int section) {
        ShowTimesData data = getData();
        if (data == null && data.getList() == null) return;
        if (holder.cinema_subTitle != null && holder.cinema_title != null) {
            Cinema cinema = (Cinema) data.getList().get(section);
            holder.cinema_subTitle.setText(cinema.getAddress());
            holder.cinema_title.setText(cinema.getCinemaName());
        }
    }

    @Override
    public void onBindViewHolder(MovieTimeTableHolder holder, int section, int relativePosition, int absolutePosition) {
        MovieShowTimesData data = getData();
        if (data == null && data.getList() == null && data.getSchedulesMap() == null) return;
        final Cinema cinema = data.getList().get(section);
        final List<Schedule> scheduleList = data.getSchedulesMap().get(cinema.getCinemaId());
        final Schedule schedule = scheduleList.get(relativePosition);
        holder.scheduleButton.setText(schedule.getShowTimesString());
        holder.scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onScheduleClick(schedule, cinema);
            }
        });
    }


    @Override
    public MovieTimeTableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = R.layout.layout_detail_time_table_item;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                layout = R.layout.layout_detail_movie_time_table_item_header;
                break;
            case VIEW_TYPE_ITEM:
                layout = R.layout.layout_detail_time_table_item;
                break;
        }

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new MovieTimeTableHolder(v);
    }

    public class MovieTimeTableHolder extends RecyclerView.ViewHolder {
        final Button scheduleButton;
        private final TextView cinema_subTitle;
        private final TextView cinema_title;

        public MovieTimeTableHolder(View itemView) {
            super(itemView);
            scheduleButton = (Button) itemView.findViewById(R.id.item_schedule);
            cinema_subTitle = (TextView) itemView.findViewById(R.id.cinema_subTitle);
            cinema_title = (TextView) itemView.findViewById(R.id.cinema_title);
        }
    }
}