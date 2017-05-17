package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.RegionManager;
import com.cinecentre.cinecentrecinema.rest.model.Region;

import java.util.List;

/**
 * Created by victg on 28.03.2017.
 */
public class RegionPresenter extends BasePresenter<RegionView> {

    public RegionPresenter(Context context) {
        super(context);
    }


    public void getListRegion() {
        RegionManager.getInstance(getContext()).getAllRegions(new RegionManager.OnGetRegionListener() {
            @Override
            public void onGetRegions(List<Region> allRegions) {
                if (isViewAttached()) getView().onSetData(allRegions);
            }

            @Override
            public void onError(String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }

    public void saveRegion(Region region) {
        RegionManager.getInstance(getContext()).saveRegion(region);
    }
}
