package com.cinecentre.cinecentrecinema.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.IntentStarter;
import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.customviews.CinemaImageView;
import com.cinecentre.cinecentrecinema.interfaces.AdapterViewItemClickListener;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.response.CinemaData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CustomViewHolder> {

    private List<Cinema> cinemaList;
    private Context mContext;


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AdapterViewItemClickListener mListener;
        @BindView(R.id.cinema_poster)
        CinemaImageView cinema_thumbnail;
        @BindView(R.id.cinema_title)
        TextView cinema_title;
        @BindView(R.id.cinema_subTitle)
        TextView cinema_subTitle;

        public CustomViewHolder(View view, AdapterViewItemClickListener listener) {
            super(view);
            mListener = listener;
            view.setOnClickListener(this);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mListener.onItemClick(view, position);
        }
    }

    public CinemaAdapter(Context context) {
        mContext = context;
    }

    public void update(CinemaData data) {
        this.cinemaList = data.getCinemas();
        notifyDataSetChanged();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cinema_item, parent, false);
        return new CustomViewHolder(itemView, new AdapterViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Cinema cinema = cinemaList.get(position);
                IntentStarter.navigateCinemaDetailsActivity(mContext, cinema);
            }
        });
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Cinema cinema = cinemaList.get(position);
        holder.cinema_thumbnail.setImageUrl(cinema.getImage(), R.drawable.placeholder_cinema);
        holder.cinema_title.setText(cinema.getCinemaName());
        holder.cinema_subTitle.setText(cinema.getAddress());
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (cinemaList != null) count = cinemaList.size();
        return count;
    }
}
