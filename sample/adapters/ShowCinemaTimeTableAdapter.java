package com.cinecentre.cinecentrecinema.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.customviews.MovieImageView;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.cinecentre.cinecentrecinema.rest.response.CinemaShowTimesData;

import java.util.List;

/**
 * Created by victg on 15.03.2017.
 */
public class ShowCinemaTimeTableAdapter extends BaseSectionedRecyclerViewAdapter<CinemaShowTimesData, ShowCinemaTimeTableAdapter.TimeTableHolder> {
    private CinemaShowTimesData data;

    public void setData(CinemaShowTimesData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getSectionCount() {
        int size = 0;
        if (data != null && data.getSchedulesMap() != null) size = data.getSchedulesMap().size();
        return size;
    }

    @Override
    public int getItemCount(int section) {
        int sectionItemCount = 0;
        if (data != null && data.getList() != null && data.getSchedulesMap() != null) {
            Film film = data.getList().get(section);
            sectionItemCount = data.getSchedulesMap().get(film.getMovieId()).size(); // even sections get 4 items
        }
        return sectionItemCount;
    }


    @Override
    public void onBindHeaderViewHolder(TimeTableHolder holder, int section) {
        if (data == null && data.getList() == null) return;
        if (holder.movie_title != null) {
            Film film = data.getList().get(section);
            holder.movie_title.setText(film.getMovieName());
            holder.movie_subTitle.setText(film.getGenres() + ", " + film.getReleaseDate());
            holder.movie_length.setText(film.getLengthString());
            holder.movie_certificate.setText(film.getCertificate());
            holder.movie_rating.setText("4.7");
            holder.movie_poster.setImageUrl(film.getImage(), R.drawable.placeholder_movie);
        }
    }

    @Override
    public void onBindViewHolder(TimeTableHolder holder, int section, int relativePosition, int absolutePosition) {
        if (data == null && data.getList() == null && data.getSchedulesMap() == null) return;
        final Film film = data.getList().get(section);
        final List<Schedule> scheduleList = data.getSchedulesMap().get(film.getMovieId());
        final Schedule schedule = scheduleList.get(relativePosition);
        final Cinema cinema = data.getCinema();
        holder.scheduleButton.setText(schedule.getShowTimesString());
        holder.scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onScheduleClick(schedule, cinema);
            }
        });
    }


    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1)
            return 0; // VIEW_TYPE_HEADER is -2, VIEW_TYPE_ITEM is -1. You can return 0 or greater.
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @Override
    public TimeTableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                layout = R.layout.layout_detail_cinema_time_table_item_header;
                break;
            case VIEW_TYPE_ITEM:
                layout = R.layout.layout_detail_time_table_item;
                break;
            default:
                layout = R.layout.layout_detail_time_table_item;
                break;
        }

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new TimeTableHolder(v);
    }

    public class TimeTableHolder extends RecyclerView.ViewHolder {
        final Button scheduleButton;
        private final TextView movie_title, movie_subTitle, movie_length, movie_certificate, movie_rating;
        private final MovieImageView movie_poster;


        public TimeTableHolder(View itemView) {
            super(itemView);
            movie_poster = (MovieImageView) itemView.findViewById(R.id.movie_poster);
            scheduleButton = (Button) itemView.findViewById(R.id.item_schedule);
            movie_subTitle = (TextView) itemView.findViewById(R.id.movie_subTitle);
            movie_title = (TextView) itemView.findViewById(R.id.movie_title);
            movie_length = (TextView) itemView.findViewById(R.id.movie_length);
            movie_certificate = (TextView) itemView.findViewById(R.id.movie_certificate);
            movie_rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
