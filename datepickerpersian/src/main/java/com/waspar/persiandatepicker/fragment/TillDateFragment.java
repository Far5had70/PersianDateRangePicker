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
import static com.waspar.persiandatepicker.PersianDateRangePicker.dayUntil;
import static com.waspar.persiandatepicker.PersianDateRangePicker.monthUntil;
import static com.waspar.persiandatepicker.PersianDateRangePicker.yearUntil;

public class TillDateFragment extends Fragment {

    private WheelPickerView Day_WheelPicker, Month_WheelPicker, Year_WheelPicker;
    ShamsiDate shamsiDate = new ShamsiDate();

    public static TillDateFragment newInstance() {
        TillDateFragment fragment = new TillDateFragment();
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
        setupWheelPickerDay(dayUntil);
        setupWheelPickerMonth(monthUntil);
        setupWheelPickerYear(yearUntil);
        setSizeAndColor();
        return view;
    }

    private void setSizeAndColor() {


        if (WheelTextColor != -1) {
            Day_WheelPicker.settextColor(WheelTextColor);
            Month_WheelPicker.settextColor(WheelTextColor);
            Year_WheelPicker.settextColor(WheelTextColor);
        }

        if (WheelTextColorSelected != -1) {
            Day_WheelPicker.setTextColorSelected(WheelTextColorSelected);
            Month_WheelPicker.setTextColorSelected(WheelTextColorSelected);
            Year_WheelPicker.setTextColorSelected(WheelTextColorSelected);
        }

        if (WheelTextSize != -1) {
            Day_WheelPicker.setTextSize(WheelTextSize*3);
            Month_WheelPicker.setTextSize(WheelTextSize*3);
            Year_WheelPicker.setTextSize(WheelTextSize*3);
        }
    }

        private void setupWheelPickerDay(String day) {
        final List<String> strings = new ArrayList<>();
        int dayy = Integer.parseInt(day);
        int ii = 0;
            int monthSize = 0;
            if (monthUntil.equals("1")||monthUntil.equals("2")||monthUntil.equals("3")||monthUntil.equals("4")||monthUntil.equals("5")||monthUntil.equals("6")){
                monthSize = 31;
            }else if (monthUntil.equals("7")||monthUntil.equals("8")||monthUntil.equals("9")||monthUntil.equals("10")||monthUntil.equals("11")){
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
        Day_WheelPicker.setPicker(strings);
        Day_WheelPicker.setCurrentItems(ii);
        Day_WheelPicker.setCyclic(true);
        Day_WheelPicker.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                dayUntil = strings.get(option);
            }
        });
    }


    private void setupWheelPickerMonth(String month) {
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
        int ii = Integer.parseInt(month);
        ii = ii-1;
        Month_WheelPicker.setPicker(strings);
        Month_WheelPicker.setCurrentItems(ii);
        Month_WheelPicker.setCyclic(true);
        Month_WheelPicker.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                monthUntil = String.valueOf(option+1);
                setupWheelPickerDay(dayUntil);
            }
        });
    }

    private void setupWheelPickerYear(String year) {
        final List<String> strings = new ArrayList<>();
        int yearr = Integer.parseInt(year);
        int ii = 0;
        for (int i = (shamsiDate.getCurrentShamsiyear()-100); i <= shamsiDate.getCurrentShamsiyear(); i++) {
            strings.add("" + i);
            if (i == yearr){
                ii = i-(shamsiDate.getCurrentShamsiyear()-100);
            }
        }
        Year_WheelPicker.setPicker(strings);
        Year_WheelPicker.setCurrentItems(ii);
        Year_WheelPicker.setCyclic(true);
        Year_WheelPicker.setOnOptionChangedListener(new WheelPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(WheelPickerView view, int option) {
                yearUntil = strings.get(option);
            }
        });
    }

    private void init(View view) {
        Day_WheelPicker = view.findViewById(R.id.wheelPickerDay);
        Month_WheelPicker = view.findViewById(R.id.wheelPickerMonth);
        Year_WheelPicker = view.findViewById(R.id.wheelPickerYear);
    }

}