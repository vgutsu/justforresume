/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cinecentre.cinecentrecinema.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.adapters.CustomViewPagerAdapter;
import com.cinecentre.cinecentrecinema.customviews.CustomImageView;
import com.cinecentre.cinecentrecinema.fragments.DetailsFragment;
import com.cinecentre.cinecentrecinema.fragments.ShowtimesFragment;
import com.cinecentre.cinecentrecinema.rest.model.Film;

import java.io.Serializable;

import butterknife.BindView;

public class MovieDetailActivity extends BaseActivity {

    @Nullable
    @BindView(R.id.movie_poster)
    CustomImageView posterImage;
    @Nullable
    @BindView(R.id.film_title)
    TextView film_title;
    @Nullable
    @BindView(R.id.film_subTitle)
    TextView film_subTitle;
    @Nullable
    @BindView(R.id.movie_certificate)
    TextView film_certificate;
    @Nullable
    @BindView(R.id.activity_details_collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;


    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.layout_activity_movie_detail;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }


    public void initView() {
        Film film = (Film) getIntent().getSerializableExtra(EXTRA_SERIALIZABLE);
        film_title.setText(film.getMovieName());
        film_certificate.setText(film.getCertificate());
        film_subTitle.setText(film.getLengthString() + " " + film.getGenres() + ", " + film.getReleaseDate());
        posterImage.setImageUrl(film.getImage(), R.drawable.placeholder_movie);
        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsing_toolbar.setTitle(film.getMovieName());
        initData(film);
    }


    public void initData(Serializable data) {
        CustomViewPagerAdapter pagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(ShowtimesFragment.newInstance(data), getString(R.string.showtimes));
        pagerAdapter.addFragment(DetailsFragment.newInstance(data), getString(R.string.details));
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
