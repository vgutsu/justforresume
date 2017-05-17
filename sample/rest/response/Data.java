package com.cinecentre.cinecentrecinema.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by victg on 15.02.2017.
 */
public class Data {
    @SerializedName("Session")
    @Expose
    private String session;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("StatusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("Result")
    @Expose
    private boolean result;


    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
