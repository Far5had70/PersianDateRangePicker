package com.waspar.persiandatepicker;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.waspar.persiandatepicker.adapter.TabAdapterDateRangePicker;
import com.waspar.persiandatepicker.util.ShamsiDate;

@SuppressLint("ValidFragment")
public class PersianDateRangePicker extends DialogFragment implements View.OnClickListener {

    //private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapterDateRangePicker adapter;
    private View Cansel, Ok;
    private TextView DoneTxt, CanselTxt;
    private String DoneText, CanselText;
    private ShamsiDate shamsiDate = new ShamsiDate();
    private ImageView DoneImg, CanselImg;
    private TextView dateFromTv , dateToTv;

    private int backgroundColor = -1;
    private int ButtonTextColor = -1;
    private int TabTextColor = -1;
    private int TabSelectedTextColor = -1;
    private int TabIndicatorColor = -1;

    public static int WheelTextColor = -1;
    public static int WheelTextColorSelected = -1;
    public static int WheelTextSize = -1;
    public int SetCurrentItem = 1;
    public int CornerRadius = 20;

    private Drawable DoneDrawable;
    private Drawable CanselDeawable;

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
    private View view, root, root2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_persian_dare_range_picker, container, false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        init();
        setupTab();
        if (InitFromDate == null) {
            InitFromDate = shamsiDate.getCurrentShamsidate();
        }
        if (InitTillDate == null) {
            InitTillDate = shamsiDate.getCurrentShamsidate();
        }

        if (ButtonTextColor != -1) {
            DoneTxt.setTextColor(ButtonTextColor);
            CanselTxt.setTextColor(ButtonTextColor);
        }

        if (typeface != null) {
            DoneTxt.setTypeface(typeface);
            CanselTxt.setTypeface(typeface);
            dateToTv.setTypeface(typeface);
            dateFromTv.setTypeface(typeface);
        }

        if (TabIndicatorColor != -1) {
            //tabLayout.setSelectedTabIndicatorColor(TabIndicatorColor);
        }

        if (DoneText != null) {
            DoneTxt.setText(DoneText);
        }

        if (CanselText != null) {
            CanselTxt.setText(CanselText);
        }

        if (DoneDrawable != null) {
            DoneImg.setImageDrawable(DoneDrawable);
        }

        if (CanselDeawable != null) {
            CanselImg.setImageDrawable(CanselDeawable);
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

    private void init() {
        viewPager = view.findViewById(R.id.viewPager);
        //tabLayout = view.findViewById(R.id.tab_layout);
        dateFromTv = view.findViewById(R.id.textView);
        dateToTv = view.findViewById(R.id.textView2);
        DoneImg = view.findViewById(R.id.img_tick);
        CanselImg = view.findViewById(R.id.img_mult);
        Cansel = view.findViewById(R.id.cansel);
        root = view.findViewById(R.id.root);
        root2 = view.findViewById(R.id.root2);
        DoneTxt = view.findViewById(R.id.layout_persian_dare_range_picker_done_txt);
        CanselTxt = view.findViewById(R.id.layout_persian_dare_range_picker_cansel_txt);
        Cansel.setOnClickListener(this);
        Ok = view.findViewById(R.id.ok);
        Ok.setOnClickListener(this);
        dateFromTv.setOnClickListener(this);
        dateToTv.setOnClickListener(this);
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
        root2.setBackground(bgShape);

        GradientDrawable bgShape2 = new GradientDrawable();
        bgShape2.setCornerRadius(CornerRadius);
        if (backgroundColor != -1) {
            bgShape2.setColor(backgroundColor);
        } else {
            bgShape2.setColor(getActivity().getResources().getColor(R.color.white));
        }
        //tabLayout.setBackground(bgShape2);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.cansel) {
            canselButton();
        } else if (i == R.id.ok) {
            okButton();
        } else if (i == R.id.textView2) {
            dateFromTv.setTextColor(getResources().getColor(R.color.white_smoke));
            dateToTv.setTextColor(getResources().getColor(R.color.white));
            viewPager.setCurrentItem(0);
        } else if (i == R.id.textView) {
            dateFromTv.setTextColor(getResources().getColor(R.color.white));
            dateToTv.setTextColor(getResources().getColor(R.color.white_smoke));
            viewPager.setCurrentItem(1);
        }
    }

    private void canselButton() {
        rangeDate.cansel();
        dismiss();
    }

    private void okButton() {
        rangeDate.From(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        rangeDate.TillDate(Integer.parseInt(dayUntil), Integer.parseInt(monthUntil), Integer.parseInt(yearUntil));
        dismiss();
    }

    private void setupTab() {
        adapter = new TabAdapterDateRangePicker(getChildFragmentManager(), 2);
        viewPager.setAdapter(adapter);
        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(SetCurrentItem);
        if (SetCurrentItem == 1){
            dateFromTv.setTextColor(getResources().getColor(R.color.white));
            dateToTv.setTextColor(getResources().getColor(R.color.white_smoke));
        }else {
            dateFromTv.setTextColor(getResources().getColor(R.color.white_smoke));
            dateToTv.setTextColor(getResources().getColor(R.color.white));
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    dateFromTv.setTextColor(getResources().getColor(R.color.white_smoke));
                    dateToTv.setTextColor(getResources().getColor(R.color.white));
                    viewPager.setCurrentItem(0);
                } else if (position == 1) {
                    dateFromTv.setTextColor(getResources().getColor(R.color.white));
                    dateToTv.setTextColor(getResources().getColor(R.color.white_smoke));
                    viewPager.setCurrentItem(1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        viewPager.setCurrentItem(0);
//                        break;
//                    case 1:
//                        viewPager.setCurrentItem(1);
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

//        if (typeface != null) {
//            for (int i = 0; i < tabLayout.getTabCount(); i++) {
//                //noinspection ConstantConditions
//                TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab_item, null);
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

    public interface RangeDate {
        void From(int day, int month, int year);

        void TillDate(int day, int month, int year);

        void cansel();
    }

    public PersianDateRangePicker setInitFromDate(String InitFromDate) {
        this.InitFromDate = InitFromDate;
        return this;
    }

    public PersianDateRangePicker setInitTillDate(String InitTillDate) {
        this.InitTillDate = InitTillDate;
        return this;
    }

    public PersianDateRangePicker setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public PersianDateRangePicker setButtonTextColor(int ButtonTextColor) {
        this.ButtonTextColor = ButtonTextColor;
        return this;
    }

    public PersianDateRangePicker setTabTextColor(int TabTextColor) {
        this.TabTextColor = TabTextColor;
        return this;
    }

    public PersianDateRangePicker setTabSelectedTextColor(int TabSelectedTextColor) {
        this.TabSelectedTextColor = TabSelectedTextColor;
        return this;
    }

    public PersianDateRangePicker setTabIndicatorColor(int TabIndicatorColor) {
        this.TabIndicatorColor = TabIndicatorColor;
        return this;
    }

    public PersianDateRangePicker setWheelTextColor(int WheelTextColor) {
        this.WheelTextColor = WheelTextColor;
        return this;
    }

    public PersianDateRangePicker setWheelTextColorSelected(int WheelTextColorSelected) {
        this.WheelTextColorSelected = WheelTextColorSelected;
        return this;
    }

    public PersianDateRangePicker setWheelTextSize(int WheelTextSize) {
        this.WheelTextSize = WheelTextSize;
        return this;
    }

    public PersianDateRangePicker setTypeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public PersianDateRangePicker setDoneText(String DoneText) {
        this.DoneText = DoneText;
        return this;
    }

    public PersianDateRangePicker setCanselText(String CanselText) {
        this.CanselText = CanselText;
        return this;
    }

    public PersianDateRangePicker setDoneDrawable(Drawable DoneDrawable) {
        this.DoneDrawable = DoneDrawable;
        return this;
    }

    public PersianDateRangePicker setCanselDeawable(Drawable CanselDeawable) {
        this.CanselDeawable = CanselDeawable;
        return this;
    }

    public PersianDateRangePicker setCurrentItem(int SetCurrentItem) {
        this.SetCurrentItem = SetCurrentItem;
        return this;
    }

    public PersianDateRangePicker setListener(RangeDate rangeDate) {
        this.rangeDate = rangeDate;
        return this;
    }

    public PersianDateRangePicker setCornerRadius(int CornerRadius) {
        this.CornerRadius = CornerRadius;
        return this;
    }

}
