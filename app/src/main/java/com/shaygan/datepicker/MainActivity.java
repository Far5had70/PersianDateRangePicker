package com.shaygan.datepicker;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.waspar.persiandatepicker.PersianDateRangePicker;
import com.waspar.persiandatepicker.util.InitDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.datePicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });
    }

    private void datePicker() {

        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");

        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDateRangePicker persianDateRangePicker = new PersianDateRangePicker(
                InitDate.inputPersianDate(1 , 1 , 1397) ,
                InitDate.inputPersianDate(1,7,1397) ,
                getResources().getColor(R.color.green) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white) ,
                getResources().getColor(R.color.white_smoke) ,
                getResources().getColor(R.color.white) ,
                20 ,
                face ,
                new PersianDateRangePicker.RangeDate() {
                    @Override
                    public void From(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, ""+day+"  "+month+"  "+year, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void TillDate(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, ""+day+"  "+month+"  "+year, Toast.LENGTH_SHORT).show();
                    }
                });
        persianDateRangePicker.show(fragmentManager,"PersianDateRangePicker");

    }
}
