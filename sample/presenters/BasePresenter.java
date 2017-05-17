package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.RegionManager;
import com.cinecentre.cinecentrecinema.rest.RestClient;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by victg on 27.03.2017.
 */
public class BasePresenter<V extends MvpView> extends MvpBasePresenter<V> {


    public interface ViewData<T> extends MvpView {
        void onSetData(T data);

        void onShowMessage(String error);
    }

    private int regionId;
    private Context context;

    private RestClient restClient;


    public Context getContext() {
        return context;
    }

    public BasePresenter(Context context) {
        this.context = context;
        this.regionId = RegionManager.getInstance(context).getSavedRegion().getRegionId();
        this.restClient = RestClient.getInstance();
    }

    int getRegionId() {
        return regionId;
    }

    RestClient getClient() {
        return restClient;
    }

}
