package com.cinecentre.cinecentrecinema.interfaces;

import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;

/**
 * Created by victg on 27.03.2017.
 */
public interface ScheduleClickCallback {
    void onScheduleClick(Schedule schedule, Cinema cinema);
}
