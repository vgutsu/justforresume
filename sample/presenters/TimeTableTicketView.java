package com.cinecentre.cinecentrecinema.presenters;

import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;
import com.cinecentre.cinecentrecinema.rest.model.TicketType;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

import java.util.List;

/**
 * Created by victg on 04.04.2017.
 */
public interface TimeTableTicketView extends BasePresenter.ViewData<ShowTimesData> {
    void onShowTicketList(List<TicketType> list);

    void onContinue(TickettypesData data);
}
