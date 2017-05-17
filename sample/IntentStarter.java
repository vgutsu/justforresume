package com.cinecentre.cinecentrecinema;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.activities.BookingFragmentActivity;
import com.cinecentre.cinecentrecinema.activities.CinemaDetailsActivity;
import com.cinecentre.cinecentrecinema.activities.MainActivity;
import com.cinecentre.cinecentrecinema.activities.MovieDetailActivity;
import com.cinecentre.cinecentrecinema.activities.SignInUpFragmentActivity;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

/**
 * A simple helper class that helps to create and launch Intents. It checks if we our device is a
 * phone or a tablet app.
 */
// TODO make it injectable with dagger
public class IntentStarter {

    public static void navigateBookingFragmentActivity(Context context, TickettypesData data) {
        Intent intent = new Intent(context, BookingFragmentActivity.class);
        intent.putExtra(BaseActivity.EXTRA_SERIALIZABLE, data);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeBasic();
        ActivityCompat.startActivity(context, intent, options.toBundle());
    }

    public static void navigateCinemaDetailsActivity(Context context, Cinema cinema) {
        Intent intent = new Intent(context, CinemaDetailsActivity.class);
        intent.putExtra(BaseActivity.EXTRA_SERIALIZABLE, cinema);
        ActivityCompat.startActivity(context, intent, null);
    }

    public static void navigateMovieDetailActivity(Context context, Film film) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(BaseActivity.EXTRA_SERIALIZABLE, film);
        ActivityCompat.startActivity(context, intent, null);
    }

    public static void navigateSignInUpFragmentActivity(Context context) {
        Intent intent = new Intent(context, SignInUpFragmentActivity.class);
        context.startActivity(intent);
    }

    public static void navigateMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
