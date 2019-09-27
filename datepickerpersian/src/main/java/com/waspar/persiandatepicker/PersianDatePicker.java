package com.waspar.persiandatepicker;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.waspar.persiandatepicker.adapter.TabAdapterDatePicker;
import com.waspar.persiandatepicker.util.ShamsiDate;

@SuppressLint("ValidFragment")
public class PersianDatePicker extends DialogFragment implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapterDatePicker adapter;
    private View Cansel, Ok;
    private TextView DoneTxt, CanselTxt;
    private String DoneText , CanselText;
    private ShamsiDate shamsiDate = new ShamsiDate();
    private ImageView DoneImg , CanselImg;

    private int backgroundColor = -1;
    private int ButtonTextColor = -1;
    private int TabTextColor = -1;
    private int TabSelectedTextColor = -1;
    private int TabIndicatorColor = -1;

    public static int WheelTextColor = -1;
    public static int WheelTextColorSelected = -1;
    public static int WheelTextSize = -1;
    public int CornerRadius = 20;

    private Drawable DoneDrawable;
    private Drawable CanselDeawable;

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
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        init(view);
        setupTab();
        if (InitFromDate == null) {
            InitFromDate = shamsiDate.getCurrentShamsidate();
        }
//
//        if (backgroundColor != -1) {
//            tabLayout.setBackgroundColor(backgroundColor);
//
//            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//
//            GradientDrawable bgShape = new GradientDrawable();
//            bgShape.setCornerRadii(new float[]{80, 80, 80, 80, 80, 80, 80, 80});
//            bgShape.setCornerRadius(80);
//            bgShape.setColor(backgroundColor);
//            root.setBackground(bgShape);
//            tabLayout.setBackground(bgShape);
//        }

        if (ButtonTextColor != -1) {
            DoneTxt.setTextColor(ButtonTextColor);
            CanselTxt.setTextColor(ButtonTextColor);
        }

        if (typeface != null){
            DoneTxt.setTypeface(typeface);
            CanselTxt.setTypeface(typeface);
        }

        if (TabIndicatorColor != -1) {
            tabLayout.setSelectedTabIndicatorColor(TabIndicatorColor);
        }

        if (DoneText != null){
            DoneTxt.setText(DoneText);
        }

        if (CanselText != null){
            CanselTxt.setText(CanselText);
        }

        if (DoneDrawable != null){
            DoneImg.setImageDrawable(DoneDrawable);
        }

        if (CanselDeawable != null){
            CanselImg.setImageDrawable(CanselDeawable);
        }

        String[] from = InitFromDate.split("/");
        day = from[2];
        month = from[1];
        year = from[0];

        return view;
    }

    private void init(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tab_layout);
        Cansel = view.findViewById(R.id.cansel);
        DoneImg = view.findViewById(R.id.img_tick);
        CanselImg = view.findViewById(R.id.img_mult);
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
        GradientDrawable bgShape = new GradientDrawable();
        bgShape.setCornerRadius(CornerRadius);
        if (backgroundColor != -1) {
            bgShape.setColor(backgroundColor);
        } else {
            bgShape.setColor(getActivity().getResources().getColor(R.color.white));
        }
        root.setBackground(bgShape);

        GradientDrawable bgShape2 = new GradientDrawable();
        bgShape2.setCornerRadius(CornerRadius);
        if (backgroundColor != -1) {
            bgShape2.setColor(backgroundColor);
        } else {
            bgShape2.setColor(getActivity().getResources().getColor(R.color.white));
        }
        tabLayout.setBackground(bgShape2);
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
        rangeDate.Cansel();
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

//        if (typeface != null){
//            for (int i = 0; i < tabLayout.getTabCount(); i++) {
//                //noinspection ConstantConditions
//                TextView tv = (TextView)LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab_item,null);
//                tv.setTypeface(typeface);
//
//                if (TabTextColor != -1 && TabSelectedTextColor != -1) {
//                    tv.setTextColor(TabTextColor);
//                }
//
//                tabLayout.getTabAt(i).setCustomView(tv);
//            }
//        }
    }

    public interface PickDate {
        void Date(int day, int month, int year);
        void Cansel();
    }

    public PersianDatePicker setInitFromDate(String InitFromDate) {
        this.InitFromDate = InitFromDate;
        return this;
    }

    public PersianDatePicker setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public PersianDatePicker setButtonTextColor(int ButtonTextColor) {
        this.ButtonTextColor = ButtonTextColor;
        return this;
    }

    public PersianDatePicker setTabTextColor(int TabTextColor) {
        this.TabTextColor = TabTextColor;
        return this;
    }

    public PersianDatePicker setTabSelectedTextColor(int TabSelectedTextColor) {
        this.TabSelectedTextColor = TabSelectedTextColor;
        return this;
    }

    public PersianDatePicker setTabIndicatorColor(int TabIndicatorColor) {
        this.TabIndicatorColor = TabIndicatorColor;
        return this;
    }

    public PersianDatePicker setWheelTextColor(int WheelTextColor) {
        this.WheelTextColor = WheelTextColor;
        return this;
    }

    public PersianDatePicker setWheelTextColorSelected(int WheelTextColorSelected) {
        this.WheelTextColorSelected = WheelTextColorSelected;
        return this;
    }

    public PersianDatePicker setWheelTextSize(int WheelTextSize) {
        this.WheelTextSize = WheelTextSize;
        return this;
    }

    public PersianDatePicker setTypeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public PersianDatePicker setDoneText(String DoneText) {
        this.DoneText = DoneText;
        return this;
    }

    public PersianDatePicker setCanselText(String CanselText) {
        this.CanselText = CanselText;
        return this;
    }

    public PersianDatePicker setDoneDrawable(Drawable DoneDrawable) {
        this.DoneDrawable = DoneDrawable;
        return this;
    }

    public PersianDatePicker setCanselDeawable(Drawable CanselDeawable) {
        this.CanselDeawable = CanselDeawable;
        return this;
    }

    public PersianDatePicker setListener(PickDate pickDate) {
        this.rangeDate = pickDate;
        return this;
    }

    public PersianDatePicker setCornerRadius(int CornerRadius) {
        this.CornerRadius = CornerRadius;
        return this;
    }
    
}
