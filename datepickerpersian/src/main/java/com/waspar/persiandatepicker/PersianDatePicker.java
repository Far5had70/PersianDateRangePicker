package com.waspar.persiandatepicker;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.waspar.persiandatepicker.adapter.TabAdapterDatePicker;
import com.waspar.persiandatepicker.util.ShamsiDate;

@SuppressLint("ValidFragment")
public class PersianDatePicker extends DialogFragment implements View.OnClickListener {

    @SuppressLint("ValidFragment")
    public PersianDatePicker(String initFromDate, PickDate rangeDate) {
        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
    }

    @SuppressLint("ValidFragment")
    public PersianDatePicker(
            String initFromDate,
            int backgroundColor,
            int ButtonTextColor,
            int TabTextColor,
            int TabSelectedTextColor,
            int TabIndicatorColor,
            int WheelTextColor,
            int WheelTextColorSelected,
            int WheelTextSize,
            PickDate rangeDate) {

        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
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
    public PersianDatePicker(
            String initFromDate,
            int backgroundColor,
            int ButtonTextColor,
            int TabTextColor,
            int TabSelectedTextColor,
            int TabIndicatorColor,
            int WheelTextColor,
            int WheelTextColorSelected,
            int WheelTextSize,
            Typeface typeface ,
            PickDate rangeDate) {

        this.rangeDate = rangeDate;
        InitFromDate = initFromDate;
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
    public PersianDatePicker(PickDate rangeDate) {
        this.rangeDate = rangeDate;
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapterDatePicker adapter;
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

    private PickDate rangeDate;
    private String InitFromDate;
    private View view, root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_persian_date_picker, container, false);
        setCorner();
        init(view);
        setupTab();
        if (InitFromDate == null) {
            InitFromDate = shamsiDate.getCurrentShamsidate();
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

        if (typeface != null){
            DoneTxt.setTypeface(typeface);
            CanselTxt.setTypeface(typeface);
        }

        if (TabTextColor != -1 && TabSelectedTextColor != -1 && TabIndicatorColor != -1) {
            tabLayout.setTabTextColors(TabTextColor , TabSelectedTextColor);
            tabLayout.setSelectedTabIndicatorColor(TabIndicatorColor);
        }

        String[] from = InitFromDate.split("/");
        day = from[2];
        month = from[1];
        year = from[0];

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
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

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
        rangeDate.Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        dismiss();
    }

    private void setupTab() {
        adapter = new TabAdapterDatePicker(getChildFragmentManager(), tabLayout.getTabCount());
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

    public interface PickDate {
        void Date(int day, int month, int year);
    }
}
