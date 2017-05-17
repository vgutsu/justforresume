package com.cinecentre.cinecentrecinema.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by victg on 27.01.2017.
 */
public class ApiResponse<T> {

    @SerializedName("errorcode")
    @Expose
    private int errorcode;

    @SerializedName("getStatus")
    @Expose
    private String statusMessage;

    @SerializedName("error")
    @Expose
    private String errorMessage = null;

    @SerializedName("data")
    @Expose
    protected T data;

    public T getData() {
        return data;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public ApiResponse() {
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
