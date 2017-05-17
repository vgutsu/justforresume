package com.cinecentre.cinecentrecinema.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignUpInView extends RelativeLayout {

    @BindView(R.id.view_user_info)
    View viewUserInfo;
    @BindView(R.id.view_sign_in_up)
    View viewSignInUp;
    @BindView(R.id.user_name)
    TextView user_name;
    @BindView(R.id.user_mail)
    TextView user_mail;

    public SignUpInView(Context context) {
        this(context, null);
    }

    public SignUpInView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public SignUpInView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public SignUpInView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.circle_text_view, this);
        ButterKnife.bind(this);
    }

    public void showInfoView(String name, String mail) {
        viewSignInUp.setVisibility(GONE);
        viewUserInfo.setVisibility(VISIBLE);
        user_mail.setText(mail);
        user_name.setText(name);
    }

    public void showSignInUpView() {
        viewSignInUp.setVisibility(VISIBLE);
        viewUserInfo.setVisibility(GONE);
    }

    public void setOnSignInUpClickListener(OnSignInUpClickListener l) {
        viewSignInUp.setOnClickListener(l);
        viewUserInfo.setOnClickListener(l);
    }

    public static abstract class OnSignInUpClickListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.view_sign_in_up:
                    signInUp();
                    break;
                case R.id.view_user_info:
                    updateUserInfo();
                    break;
                default:
                    break;
            }
        }

        public abstract void signInUp();

        public abstract void updateUserInfo();

    }
}
