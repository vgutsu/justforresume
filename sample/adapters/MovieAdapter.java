package com.cinecentre.cinecentrecinema.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.IntentStarter;
import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.customviews.MovieImageView;
import com.cinecentre.cinecentrecinema.interfaces.AdapterViewItemClickListener;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.response.MoviesData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CustomViewHolder> {

    private Context mContext;
    private List<Film> filmList;

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AdapterViewItemClickListener mListener;
        @BindView(R.id.film_subTitle)
        TextView subTitle;
        @BindView(R.id.film_title)
        TextView title;
        @BindView(R.id.movie_poster)
        public MovieImageView thumbnail;

        public CustomViewHolder(View view, AdapterViewItemClickListener listener) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            this.mListener = listener;
        }

        @Override
        public void onClick(View view) {
            int itemPostion = getAdapterPosition();
            mListener.onItemClick(view, itemPostion);
        }
    }

    public MovieAdapter(Context context) {
        mContext = context;
    }

    public void update(MoviesData data) {
        this.filmList = data.getFilms();
        notifyDataSetChanged();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_item, parent, false);
        return new CustomViewHolder(itemView, new AdapterViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                IntentStarter.navigateMovieDetailActivity(mContext, filmList.get(position));
            }
        });
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (filmList == null) return;
        Film film = filmList.get(position);
        holder.thumbnail.setImageUrl(film.getImage(), R.drawable.placeholder_movie);
        holder.title.setText(film.getMovieName());
        holder.subTitle.setText(film.getReleaseDate() + ", " + film.getGenres());
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (filmList != null) count = filmList.size();
        return count;
    }

}