package com.waspar.persiandatepicker;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.waspar.persiandatepicker.adapter.TabAdapter;
import com.waspar.persiandatepicker.util.ShamsiDate;

@SuppressLint("ValidFragment")
public class PersianDateRangePicker extends DialogFragment implements View.OnClickListener {

    @SuppressLint("ValidFragment")
    public PersianDateRangePicker(String initFromDate, String initTillDate, RangeDate rangeDate) {
        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
        InitTillDate = initTillDate;
    }

    @SuppressLint("ValidFragment")
    public PersianDateRangePicker(
            String initFromDate,
            String initTillDate,
            int backgroundColor,
            int ButtonTextColor,
            int TabTextColor,
            int TabSelectedTextColor,
            int TabIndicatorColor,
            int WheelTextColor,
            int WheelTextColorSelected,
            int WheelTextSize,
            RangeDate rangeDate) {

        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
        InitTillDate = initTillDate;
        this.backgroundColor = backgroundColor;
        this.ButtonTextColor = ButtonTextColor;
        this.TabTextColor = TabTextColor;
        this.TabSelectedTextColor = TabSelectedTextColor;
        this.TabIndicatorColor = TabIndicatorColor;
        this.WheelTextColor = WheelTextColor;
        this.WheelTextColorSelected = WheelTextColorSelected;
        this.WheelTextSize = WheelTextSize;
    }

    @SuppressLint("ValidFragment")
    public PersianDateRangePicker(
            String initFromDate,
            String initTillDate,
            int backgroundColor,
            int ButtonTextColor,
            int TabTextColor,
            int TabSelectedTextColor,
            int TabIndicatorColor,
            int WheelTextColor,
            int WheelTextColorSelected,
            int WheelTextSize,
            Typeface typeface ,
            RangeDate rangeDate) {

        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
        InitTillDate = initTillDate;
        this.backgroundColor = backgroundColor;
        this.ButtonTextColor = ButtonTextColor;
        this.TabTextColor = TabTextColor;
        this.TabSelectedTextColor = TabSelectedTextColor;
        this.TabIndicatorColor = TabIndicatorColor;
        this.WheelTextColor = WheelTextColor;
        this.WheelTextColorSelected = WheelTextColorSelected;
        this.WheelTextSize = WheelTextSize;
        this.typeface = typeface;
    }

    @SuppressLint("ValidFragment")
    public PersianDateRangePicker(RangeDate rangeDate) {
        this.rangeDate = rangeDate;
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter adapter;
    private View Cansel, Ok;
    private TextView DoneTxt, CanselTxt;
    private ShamsiDate shamsiDate = new ShamsiDate();

    private int backgroundColor = -1;
    private int ButtonTextColor = -1;
    private int TabTextColor = -1;
    private int TabSelectedTextColor = -1;
    private int TabIndicatorColor = -1;

    public static int WheelTextColor = -1;
    public static int WheelTextColorSelected = -1;
    public static int WheelTextSize = -1;

    public static Typeface typeface;

    public static String day;
    public static String month;
    public static String year;
    public static String dayUntil;
    public static String monthUntil;
    public static String yearUntil;

    private RangeDate rangeDate;
    private String InitFromDate;
    private String InitTillDate;
    private View view, root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_persian_dare_range_picker, container, false);
        setCorner();
        init(view);
        setupTab();
        if (InitFromDate == null) {
            InitFromDate = shamsiDate.getCurrentShamsidate();
        }
        if (InitTillDate == null) {
            InitTillDate = shamsiDate.getCurrentShamsidate();
        }

        if (backgroundColor != -1) {
            tabLayout.setBackgroundColor(backgroundColor);

            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            GradientDrawable bgShape = new GradientDrawable();
            bgShape.setCornerRadii(new float[]{80, 80, 80, 80, 80, 80, 80, 80});
            bgShape.setCornerRadius(80);
            bgShape.setColor(backgroundColor);
            root.setBackground(bgShape);
            tabLayout.setBackground(bgShape);
        }

        if (ButtonTextColor != -1) {
            DoneTxt.setTextColor(ButtonTextColor);
            CanselTxt.setTextColor(ButtonTextColor);
        }

        if (TabTextColor != -1 && TabSelectedTextColor != -1 && TabIndicatorColor != -1) {
            tabLayout.setTabTextColors(TabTextColor , TabSelectedTextColor);
            tabLayout.setSelectedTabIndicatorColor(TabIndicatorColor);
        }

        String[] from = InitFromDate.split("/");
        String[] till = InitTillDate.split("/");
        day = from[2];
        month = from[1];
        year = from[0];
        dayUntil = till[2];
        monthUntil = till[1];
        yearUntil = till[0];

        return view;
    }

    private void setCorner() {
        //  getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_rounded_bg);
    }

    private void init(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tab_layout);
        Cansel = view.findViewById(R.id.cansel);
        root = view.findViewById(R.id.root);
        DoneTxt = view.findViewById(R.id.layout_persian_dare_range_picker_done_txt);
        CanselTxt = view.findViewById(R.id.layout_persian_dare_range_picker_cansel_txt);
        Cansel.setOnClickListener(this);
        Ok = view.findViewById(R.id.ok);
        Ok.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT - 1;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        if (backgroundColor != -1) {
            tabLayout.setBackgroundColor(backgroundColor);

            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            GradientDrawable bgShape = new GradientDrawable();
            bgShape.setCornerRadii(new float[]{80, 80, 80, 80, 80, 80, 80, 80});
            bgShape.setCornerRadius(80);
            bgShape.setColor(backgroundColor);
            root.setBackground(bgShape);
            tabLayout.setBackground(bgShape);
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.cansel) {
            canselButton();
        } else if (i == R.id.ok) {
            okButton();
        }
    }

    private void canselButton() {
        dismiss();
    }

    private void okButton() {
        rangeDate.From(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        rangeDate.TillDate(Integer.parseInt(dayUntil), Integer.parseInt(monthUntil), Integer.parseInt(yearUntil));
        dismiss();
    }

    private void setupTab() {
        adapter = new TabAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        if (typeface != null){
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                //noinspection ConstantConditions
                TextView tv = (TextView)LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab_item,null);
                tv.setTypeface(typeface);
                tabLayout.getTabAt(i).setCustomView(tv);
            }
        }
    }

    public interface RangeDate {
        void From(int day, int month, int year);

        void TillDate(int day, int month, int year);
    }
}
