package com.cinecentre.cinecentrecinema.rest;

import com.cinecentre.cinecentrecinema.rest.model.RestError;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static RestError parseError(Response<?> response) {

        try {
            Converter<ResponseBody, RestError> converter =
                    RestClient.getInstance().retrofit().responseBodyConverter(RestError.class, RestError.class.getAnnotations());
            RestError error;
            error = converter.convert(response.errorBody());
            return error;
        } catch (IOException e) {
            return new RestError();
        }
    }
}