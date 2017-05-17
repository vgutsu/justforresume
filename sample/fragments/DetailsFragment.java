package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.adapters.SimpleMapAdapter;
import com.cinecentre.cinecentrecinema.presenters.DetailsPresenter;
import com.cinecentre.cinecentrecinema.rest.model.Film;

import java.io.Serializable;

import butterknife.BindView;


/**
 * Created by victg on 07.02.2017.
 */

public class DetailsFragment extends BaseFragment {
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.synopsis)
    TextView synopsis;
    @BindView(R.id.youtube_webview)
    WebView youtubeWebView;

    @Override
    public int getFragmentId() {
        return ID_DETAILS;
    }

    @Override
    protected int title() {
        return NONE;
    }

    @Override
    protected int layout() {
        return R.layout.layout_movie_details_fragment;
    }

    public static BaseFragment newInstance(Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseActivity.EXTRA_SERIALIZABLE, serializable);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public DetailsPresenter createPresenter() {
        return new DetailsPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Film film = (Film) getArguments().getSerializable(BaseActivity.EXTRA_SERIALIZABLE);
        String html = "<html><body style='margin:0;padding:0;'><iframe width=\"100%\" height=\"100%\" src=\"" + film.getTrailerLink() + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        youtubeWebView.getSettings().setJavaScriptEnabled(true);
        youtubeWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        youtubeWebView.loadData(html, "text/html", "utf-8");
        youtubeWebView.setWebChromeClient(new WebChromeClient());

        synopsis.setText(film.getSynopsis());
        recycleview.setAdapter(new SimpleMapAdapter(film.returnFieldsAsMap()));
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
