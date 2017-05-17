package com.cinecentre.cinecentrecinema.adapters;

import android.support.v7.widget.RecyclerView;

import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import com.cinecentre.cinecentrecinema.interfaces.ScheduleClickCallback;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;

/**
 * Created by victg on 27.03.2017.
 */
abstract public class BaseSectionedRecyclerViewAdapter<T extends ShowTimesData, VH extends RecyclerView.ViewHolder> extends SectionedRecyclerViewAdapter<VH> {

    private ScheduleClickCallback scheduleCallback;
    private T data;

    public void setOnScheduleButtonClickListener(ScheduleClickCallback callback) {
        this.scheduleCallback = callback;
    }

    public void onScheduleClick(Schedule schedule, Cinema cinema) {
        if (scheduleCallback != null) scheduleCallback.onScheduleClick(schedule, cinema);
    }

    public void setData(T data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getSectionCount() {
        int size = 0;
        if (data != null && data.getSchedulesMap() != null) size = data.getSchedulesMap().size();
        return size;
    }

    public T getData() {
        return data;
    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1)
            return 0; // VIEW_TYPE_HEADER is -2, VIEW_TYPE_ITEM is -1. You can return 0 or greater.
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }
}
