package com.cinecentre.cinecentrecinema.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cinecentre.cinecentrecinema.R;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by victg on 19.01.2017.
 */
public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P> {

    public static final int NONE = 0;
    public static final int ID_HOME = 1;
    public static final int ID_CINEMAS = 2;
    public static final int ID_TICKETS = 3;
    public static final int ID_SETTINGS = 4;
    public static final int ID_PAYMENT = 5;
    public static final int ID_SHOW_TIMES = 5;
    public static final int ID_DETAILS = 6;
    public static final int ID_SIGN_IN = 7;
    public static final int ID_SIGN_UP = 8;
    public static final int ID_FORGOT_PASS = 9;
    public static final int ID_BUY_SEATS = 10;
    public static final int ID_BUY_SEATS_CONFIRM = 11;

    private Unbinder unBinder;
    private OnFragmentSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnFragmentSelectedListener {
        void onPushFragment(BaseFragment fragment, boolean add);

        void onClearStack();
    }

    public abstract int getFragmentId();

    public int parentContainer() {
        return R.id.content_frame;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnFragmentSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    protected abstract int title();


    public void setToolbarTitle() {
        getActivity().setTitle(getString(title()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unBinder = ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        if (title() != NONE) setToolbarTitle();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != null) unBinder.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layout(), container, false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                search();
                break;
            default:
                break;
        }
        return false;
    }

    protected void search() {
        Toast.makeText(getContext(), "haven't implemented yet", Toast.LENGTH_SHORT).show();
    }

    protected abstract int layout();


    protected void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    protected void pushFragment(BaseFragment baseFragment, boolean b) {
        if (mCallback != null) mCallback.onPushFragment(baseFragment, b);
    }

    protected void pushFragment(BaseFragment baseFragment) {
        if (mCallback != null) mCallback.onPushFragment(baseFragment, false);
    }

    protected void onClearStack() {
        if (mCallback != null) mCallback.onClearStack();
    }

    protected void finish() {
        getActivity().finish();
    }

}