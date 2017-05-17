package com.cinecentre.cinecentrecinema.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class CalendarAdapter extends RecyclerTabLayout.Adapter<CalendarAdapter.ViewHolder> {

    protected static final int MAX_TAB_TEXT_LINES = 2;
    private List<MovieDate> dateList;

    protected int mTabPaddingStart;
    protected int mTabPaddingTop;
    protected int mTabPaddingEnd;
    protected int mTabPaddingBottom;
    protected boolean mTabSelectedTextColorSet = true;
    protected int mTabSelectedTextColor;
    private int mTabMaxWidth = 0;
    private int mTabMinWidth = 0;
    private int mTabBackgroundResId = android.R.color.transparent;
    private int mTabOnScreenLimit = 7;

    public CalendarAdapter(ViewPager viewPager) {
        super(viewPager);
    }

    public void setDateList(List<MovieDate> movieDateList) {
        this.dateList = movieDateList;
        notifyDataSetChanged();
    }

    @SuppressWarnings("deprecation")
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CalendarTab tabTextView = new CalendarTab(parent.getContext());
        if (mTabSelectedTextColorSet) {
            tabTextView.setTextColor(tabTextView.createColorStateList(
                    tabTextView.getCurrentTextColor(), mTabSelectedTextColor));
        }

        ViewCompat.setPaddingRelative(tabTextView, mTabPaddingStart, mTabPaddingTop,
                mTabPaddingEnd, mTabPaddingBottom);
        tabTextView.setGravity(Gravity.CENTER);
        tabTextView.setMaxLines(MAX_TAB_TEXT_LINES);
        tabTextView.setEllipsize(TextUtils.TruncateAt.END);

        if (mTabOnScreenLimit > 0) {
            int width = parent.getMeasuredWidth() / mTabOnScreenLimit;
            tabTextView.setMaxWidth(width);
            tabTextView.setMinWidth(width);

        } else {
            if (mTabMaxWidth > 0) {
                tabTextView.setMaxWidth(mTabMaxWidth);
            }
            tabTextView.setMinWidth(mTabMinWidth);
        }

        if (mTabSelectedTextColorSet) {
            tabTextView.setTextColor(tabTextView.createColorStateList(
                    tabTextView.getCurrentTextColor(), mTabSelectedTextColor));
        }
        if (mTabBackgroundResId != 0) {
            tabTextView.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(tabTextView.getContext(), mTabBackgroundResId));
        }
        tabTextView.setLayoutParams(createLayoutParamsForTabs());
        return new ViewHolder(tabTextView);
    }

    @Override
    public void onBindViewHolder(CalendarAdapter.ViewHolder holder, int position) {
        if (dateList == null) return;
        MovieDate date = dateList.get(position);
        holder.tab.setDayOfMonth(date.getDayOfMonth());
        holder.tab.setDayOfWeek(date.getDayOfWeek());
        holder.tab.setSelected(getCurrentIndicatorPosition() == position);
    }

    @Override
    public int getItemCount() {
        return getViewPager().getAdapter().getCount();
    }

    protected RecyclerView.LayoutParams createLayoutParamsForTabs() {
        return new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.MATCH_PARENT);
    }

    public void setSelectedColor(int selectedColor) {
        this.mTabSelectedTextColor = selectedColor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final CalendarTab tab;

        public ViewHolder(View itemView) {
            super(itemView);
            tab = (CalendarTab) itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != NO_POSITION) {
                        getViewPager().setCurrentItem(pos, true);
                    }
                }
            });
        }
    }

    public class CalendarTab extends LinearLayout {

        private TextView day_of_month, day_of_week;

        public CalendarTab(Context context) {
            super(context);
            init();
        }

        void init() {
            inflate(getContext(), R.layout.layout_calendar_tab, this);
            day_of_week = (TextView) findViewById(R.id.day_of_week);
            day_of_month = (TextView) findViewById(R.id.day_of_month);
        }

        public void setDayOfWeek(CharSequence text) {
            if (day_of_week != null) day_of_week.setText(text);
        }

        public void setDayOfMonth(CharSequence text) {
            if (day_of_month != null) day_of_month.setText(text);
        }

        public ColorStateList createColorStateList(int defaultColor, int selectedColor) {
            final int[][] states = new int[2][];
            final int[] colors = new int[2];
            states[0] = SELECTED_STATE_SET;
            colors[0] = selectedColor;
//             Default enabled state
            states[1] = EMPTY_STATE_SET;
            colors[1] = defaultColor;
            return new ColorStateList(states, colors);
        }

        public int getCurrentTextColor() {
            return day_of_month.getCurrentTextColor();
        }

        public void setTextColor(ColorStateList textColor) {
            day_of_month.setTextColor(textColor);
            day_of_week.setTextColor(textColor);
        }

        public void setMaxLines(int maxLines) {
            day_of_week.setMaxLines(maxLines);
            day_of_month.setMaxLines(maxLines);
        }

        public void setEllipsize(TextUtils.TruncateAt ellipsize) {
            day_of_week.setEllipsize(ellipsize);
            day_of_month.setEllipsize(ellipsize);
        }

        public void setMaxWidth(int maxWidth) {
            day_of_week.setMaxWidth(maxWidth);
            day_of_month.setMaxWidth(maxWidth);
        }

        public void setMinWidth(int minWidth) {
            day_of_month.setMinWidth(minWidth);
            day_of_week.setMinWidth(minWidth);
        }
    }
}