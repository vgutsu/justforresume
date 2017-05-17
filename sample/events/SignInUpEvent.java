package com.cinecentre.cinecentrecinema.events;

import com.cinecentre.cinecentrecinema.rest.response.Data;

/**
 * Created by victg on 16.02.2017.
 */

public class SignInUpEvent {

    private final Data data;

    public SignInUpEvent(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}
