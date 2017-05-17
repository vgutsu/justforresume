package com.cinecentre.cinecentrecinema;

import android.content.Context;
import android.content.SharedPreferences;

import com.cinecentre.cinecentrecinema.rest.RestClient;
import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.model.Region;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.RegionData;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;

/**
 * Created by victg on 17.02.2017.
 */
public class RegionManager {
    private static final String REGION_INFO = "REGION_INFO";
    private static final String REGION = "REGION";

    private static RegionManager managerSingleton;
    private final RestClient client;
    private final SharedPreferences sharedPreferences;

    private Region savedRegion;
    private List<Region> allRegions = Collections.emptyList();

    public interface OnGetRegionListener {
        void onGetRegions(List<Region> allRegions);

        void onError(String error);
    }

    private RegionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(REGION_INFO, Context.MODE_PRIVATE);
        savedRegion = getSavedRegion();
        client = RestClient.getInstance();
    }


    public static synchronized RegionManager getInstance(Context context) {
        if (null == managerSingleton) {
            managerSingleton = new RegionManager(context);
        }
        return managerSingleton;
    }

    public void getAllRegions(final OnGetRegionListener l) {
        client.getLocations(new RetrofitCallback<RegionData>() {
            @Override
            public void onFinished(Call<ApiResponse<RegionData>> call, RegionData locationData) {
                allRegions.clear();
                allRegions = locationData.getAllRegions();
                int index = allRegions.indexOf(savedRegion);
                if (index >= 0) allRegions.get(index).highLight(savedRegion);
                l.onGetRegions(allRegions);
            }

            @Override
            public void onError(Call<ApiResponse<RegionData>> call, String error) {
                l.onError(error);
            }
        });
    }

    public void saveRegion(Region region) {
        this.savedRegion = region;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(region, Region.class);
        editor.putString(REGION, json);
        editor.apply();
    }

    public Region getSavedRegion() {
        if (savedRegion == null) {
            Gson gson = new Gson();
            String json = sharedPreferences.getString(REGION, "{\"RegionId\": 0,\n" + "\"RegionName\": \"\"}");
            savedRegion = gson.fromJson(json, Region.class);
        }
        return savedRegion;
    }
}
