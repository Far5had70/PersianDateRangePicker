package com.shaygan.datepicker;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.waspar.persiandatepicker.PersianDatePicker;
import com.waspar.persiandatepicker.PersianDateRangePicker;
import com.waspar.persiandatepicker.SetCurrentItem;
import com.waspar.persiandatepicker.util.InitDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button datePicker = findViewById(R.id.datePicker);
        Button dateRangePicker = findViewById(R.id.dateRangePicker);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        dateRangePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateRangePicker();
            }
        });
    }

    private void dateRangePicker() {

        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDateRangePicker persianDateRangePicker = new PersianDateRangePicker(
                InitDate.inputPersianDate(1, 1, 1397),
                InitDate.inputPersianDate(1, 7, 1397),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white_smoke),
                getResources().getColor(R.color.white),
                20,
                face,
                "تائید",
                "بازنشانی" ,
                getResources().getDrawable(R.drawable.ic_tick),
                getResources().getDrawable(R.drawable.ic_mult),
                SetCurrentItem.From ,
                new PersianDateRangePicker.RangeDate() {
                    @Override
                    public void From(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, "" + day + "  " + month + "  " + year, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void TillDate(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, "" + day + "  " + month + "  " + year, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void cansel() {
                        Toast.makeText(MainActivity.this, "بازنشانی", Toast.LENGTH_SHORT).show();
                    }
                });
        persianDateRangePicker.show(fragmentManager, "PersianDateRangePicker");

    }

    private void datePicker() {

        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDatePicker persianDateRangePicker = new PersianDatePicker(
                InitDate.inputPersianDate(1 , 1 , 1397) ,
                getResources().getColor(R.color.green) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white_smoke) ,
                getResources().getColor(R.color.white) ,
                20 ,
                face ,
                "تائید",
                "انصراف" ,
                getResources().getDrawable(R.drawable.ic_tick),
                getResources().getDrawable(R.drawable.ic_mult),
                new PersianDatePicker.PickDate() {
                    @Override
                    public void Date(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, ""+day+"  "+month+"  "+year, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Cansel() {

                    }
                });
        persianDateRangePicker.show(fragmentManager,"PersianDateRangePicker");
    }
}
