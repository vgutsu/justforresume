package com.cinecentre.cinecentrecinema.rest;

import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.CinemaData;
import com.cinecentre.cinecentrecinema.rest.response.CinemaShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.Data;
import com.cinecentre.cinecentrecinema.rest.response.MovieShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.MoviesData;
import com.cinecentre.cinecentrecinema.rest.response.RegionData;
import com.cinecentre.cinecentrecinema.rest.response.SeatingAreaData;
import com.cinecentre.cinecentrecinema.rest.response.SeatsData;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by victg on 27.01.2017.
 */

public interface RealService {

//    Schedule api's
//    http://www.cinecentre.co.za/testapi/v1/master/help

    @GET("master/cinemas/{regionId}")
    Call<ApiResponse<CinemaData>> cinemas(@Path("regionId") int regId);

    @GET("master/movies/{regionId}")
    Call<ApiResponse<MoviesData>> movies(@Path("regionId") int regId);

    @GET("master/comingsoonmovies/{regionId}")
    Call<ApiResponse<MoviesData>> comingsoonmovies(@Path("regionId") int regId);

    @GET("master/locations")
    Call<ApiResponse<RegionData>> locations();

    @GET("master/movieinfo/{regionId}/{movieid}")
    Call<ApiResponse<Film>> movieinfo(@Path("regionId") int regId, @Path("movieid") int movId);

    @GET("master/seatingarea/{cinemaid}/{scheduleid}")
    Call<ApiResponse<SeatingAreaData>> seatingarea(@Path("cinemaid") int cinId, @Path("scheduleid") int scheduleid);

    @GET("master/showtime/cinemas/{regionId}/{movieid}/{date}")
    Call<ApiResponse<MovieShowTimesData>> showtime(@Path("regionId") int regId, @Path("movieid") int movId, @Path("date") long intDate);

    @GET("master/showtimes/{regionId}/{cinemaid}/{date}")
    Call<ApiResponse<CinemaShowTimesData>> showtimes(@Path("regionId") int regId, @Path("cinemaid") int cinId, @Path("date") long intDate);

    @GET("master/tickettypes/{cinemaid}/{scheduleid}/{seatingareaid}")
    Call<ApiResponse<TickettypesData>> tickettypes(@Path("cinemaid") int cinId, @Path("scheduleid") int schId, @Path("seatingareaid") int seatareaid);

    //    Account api's
    //    http://www.cinecentre.co.za/testapi/v1/account/help

    @POST("account/register")
    Call<ApiResponse<Data>> register(@Body UserInfo body);

    @POST("account/login")
    Call<ApiResponse<Data>> login(@Body UserInfo body);

    @POST("account/getuserprofile")
    Call<ApiResponse<UserInfo>> getuserprofile(@Header("Session") String session);

    @POST("account/checkloginstatus")
    Call<ApiResponse<Boolean>> checkloginstatus(@Header("Session") String session);

    @POST("/account/changepassword")
    Call<ApiResponse<Object>> changepassword(@Header("Session") String session, @Body UserInfo pass);

    @POST("account/logout")
    Call<ApiResponse<Boolean>> logout(@Header("Session") String session);

    @POST("/account/update")
    Call<ApiResponse<Data>> update(@Body UserInfo body);

    //    Transaction api's
    //    http://www.cinecentre.co.za/testapi/v1/trans/help
    // other api
    @GET("trans/seats/{cinemaid}/{scheduleid}/{seatingareaid}")
    Call<ApiResponse<SeatsData>> seats(@Path("cinemaid") int cinemaid, @Path("scheduleid") int scheduleid, @Path("seatingareaid") int seatingareaid);

    @GET("trans/soldseats/{cinemaid}/{scheduleid}/{seatingareaid}")
    Call<ApiResponse<Object>> soldseats(@Path("cinemaid") int cinemaid, @Path("scheduleid") int scheduleid, @Path("seatingareaid") int seatingareaid);

    @POST("inittrans")
    Call<ApiResponse<Object>> inittrans(@Body Object obj);

    @POST("updateorder")
    Call<ApiResponse<Object>> updateorder(@Body Object obj);

    //    Order info api;s
    //    http://www.cinecentre.co.za/testapi/v1/order/help
    @GET("getorderdetail/{transid}")
    Call<ApiResponse<Object>> getorderdetail(@Path("transid") int transid);

    @GET("orderstatus")
    Call<ApiResponse<Object>> orderstatus();

}


