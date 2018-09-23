package com.waspar.persiandatepicker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waspar.persiandatepicker.R;
import com.waspar.persiandatepicker.util.ShamsiDate;
import com.waspar.persiandatepicker.wheel.WheelPickerView;

import java.util.ArrayList;
import java.util.List;

import static com.waspar.persiandatepicker.PersianDateRangePicker.WheelTextColor;
import static com.waspar.persiandatepicker.PersianDateRangePicker.WheelTextColorSelected;
import static com.waspar.persiandatepicker.PersianDateRangePicker.WheelTextSize;
import static com.waspar.persiandatepicker.PersianDateRangePicker.day;
import static com.waspar.persiandatepicker.PersianDateRangePicker.month;
import static com.waspar.persiandatepicker.PersianDateRangePicker.year;

public class FromDateFragment extends Fragment {

    private WheelPickerView Day_Recyclerview, Month_Recyclerview, Year_Recyclerview;
    ShamsiDate shamsiDate = new ShamsiDate();

    public static FromDateFragment newInstance() {
        FromDateFragment fragment = new FromDateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);
        init(view);
        setupWheelPickerDay(day);
        setupWheelPickerMonth(month);
        setupWheelPickerYear(year);
        setSizeAndColor();
        return view;
    }

    private void setSizeAndColor() {


        if (WheelTextColor != -1) {
            Day_Recyclerview.settextColor(WheelTextColor);
            Month_Recyclerview.settextColor(WheelTextColor);
            Year_Recyclerview.settextColor(WheelTextColor);
        }

        if (WheelTextColorSelected != -1) {
            Day_Recyclerview.setTextColorSelected(WheelTextColorSelected);
            Month_Recyclerview.setTextColorSelected(WheelTextColorSelected);
            Year_Recyclerview.setTextColorSelected(WheelTextColorSelected);
        }

        if (WheelTextSize != -1) {
            Day_Recyclerview.setTextSize(WheelTextSize*3);
            Month_Recyclerview.setTextSize(WheelTextSize*3);
            Year_Recyclerview.setTextSize(WheelTextSize*3);
        }
    }


    private void setupWheelPickerDay(final String days) {
        final List<String> strings = new ArrayList<>();
        int dayy = Integer.parseInt(days);
        int ii = 0;
        int monthSize = 0;
        if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")){
            monthSize = 31;
        }else if (month.equals("7")||month.equals("8")||month.equals("9")||month.equals("10")||month.equals("11")){
            monthSize = 30;
        }else {
            monthSize = 29;
        }
        for (int i = 1; i <= monthSize; i++) {
            strings.add("" + i);
            if (i == dayy){
                ii = i-1;
            }
        }
        Day_Recyclerview.setPicker(strings);
        Day_Recyclerview.setCurrentItems(ii);
        Day_Recyclerview.setCyclic(true);
        Day_Recyclerview.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                day = strings.get(option);
            }
        });
    }

    private void setupWheelPickerMonth(String months) {
        List<String> strings = new ArrayList<>();
        strings.add("فروردین");
        strings.add("اردیبهشت");
        strings.add("خرداد");
        strings.add("تیر");
        strings.add("مرداد");
        strings.add("شهریور");
        strings.add("مهر");
        strings.add("آبان");
        strings.add("آذر");
        strings.add("دی");
        strings.add("بهمن");
        strings.add("اسفند");
        int ii = Integer.parseInt(months);
        ii = ii-1;
        Month_Recyclerview.setPicker(strings);
        Month_Recyclerview.setCurrentItems(ii);
        Month_Recyclerview.setCyclic(true);
        Month_Recyclerview.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                month = String.valueOf(option+1);
                setupWheelPickerDay(day);
            }
        });
    }

    private void setupWheelPickerYear(String yearrr) {
        final List<String> strings = new ArrayList<>();
        int yearr = Integer.parseInt(yearrr);
        int ii = 0;
        for (int i = (shamsiDate.getCurrentShamsiyear()-100); i <= shamsiDate.getCurrentShamsiyear(); i++) {
            strings.add("" + i);
            if (i == yearr){
                ii = i-(shamsiDate.getCurrentShamsiyear()-100);
            }
        }
        Year_Recyclerview.setPicker(strings);
        Year_Recyclerview.setCurrentItems(ii);
        Year_Recyclerview.setCyclic(true);
        Year_Recyclerview.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                year = strings.get(option);
            }
        });
    }

    private void init(View view) {
        Day_Recyclerview = view.findViewById(R.id.wheelPickerDay);
        Month_Recyclerview = view.findViewById(R.id.wheelPickerMonth);
        Year_Recyclerview = view.findViewById(R.id.wheelPickerYear);
    }

}