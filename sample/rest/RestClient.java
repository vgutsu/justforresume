package com.cinecentre.cinecentrecinema.rest;

import com.cinecentre.cinecentrecinema.BuildConfig;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.cinecentre.cinecentrecinema.rest.response.CinemaData;
import com.cinecentre.cinecentrecinema.rest.response.CinemaShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.Data;
import com.cinecentre.cinecentrecinema.rest.response.MovieShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.MoviesData;
import com.cinecentre.cinecentrecinema.rest.response.RegionData;
import com.cinecentre.cinecentrecinema.rest.response.SeatsData;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static final String BASE_URL = "http://www.cinecentre.co.za/testapi/v1/";
    private static RestClient sRestClientSingleton;
    private Retrofit retrofit;
    private RealService apiService;

    public RestClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(new HeaderInterceptor());
        if (BuildConfig.DEBUG) {
            httpclient.addInterceptor(logging);
        }

        OkHttpClient client = httpclient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // add gson here if you want to use custom date,etc
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        setApiService(RealService.class);
    }

    public void setApiService(Class<RealService> service) {
        apiService = retrofit.create(service);
    }

    private class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .header("Channel", "mobile")
                    .header("Content-Type", "application/json")
                    .build();
            return chain.proceed(request);
        }
    }

    public Retrofit retrofit() {
        return retrofit;
    }


    public static synchronized RestClient getInstance() {
        if (null == sRestClientSingleton) {
            sRestClientSingleton = new RestClient();
        }
        return sRestClientSingleton;
    }


    public void getCinemas(int regionId, RetrofitCallback<CinemaData> callback) {
        apiService.cinemas(regionId).enqueue(callback);
    }

    public void getComingSoon(int regionId, RetrofitCallback<MoviesData> callback) {
        apiService.comingsoonmovies(regionId).enqueue(callback);
    }

    public void getMovies(int regionId, RetrofitCallback<MoviesData> callback) {
        apiService.movies(regionId).enqueue(callback);
    }


    public void getLocations(RetrofitCallback<RegionData> callback) {
        apiService.locations().enqueue(callback);
    }

    public void register(UserInfo body, RetrofitCallback<Data> retrofitCallback) {
        apiService.register(body).enqueue(retrofitCallback);
    }

    public void login(UserInfo body, RetrofitCallback<Data> retrofitCallback) {
        apiService.login(body).enqueue(retrofitCallback);
    }

    public void getUserProfile(String session, RetrofitCallback<UserInfo> retrofitCallback) {
        apiService.getuserprofile(session).enqueue(retrofitCallback);
    }

    public void getShowtime(int regionId, int filmId, long timestamp, RetrofitCallback<MovieShowTimesData> retrofitCallback) {
        apiService.showtime(regionId, filmId, timestamp).enqueue(retrofitCallback);
    }

    public void getShowtimes(int regionId, int cinemaId, long timestamp, RetrofitCallback<CinemaShowTimesData> retrofitCallback) {
        apiService.showtimes(regionId, cinemaId, timestamp).enqueue(retrofitCallback);
    }

    public void getSeats(int cinemaId, int scheduleId, int regionId, RetrofitCallback<SeatsData> retrofitCallback) {
        apiService.seats(cinemaId, scheduleId, regionId).enqueue(retrofitCallback);
    }

    public void getTickettypes(int cinemaId, int scheduleId, RetrofitCallback<TickettypesData> retrofitCallback) {
        //area 1 ,always
        apiService.tickettypes(cinemaId, scheduleId, 1).enqueue(retrofitCallback);
    }


}