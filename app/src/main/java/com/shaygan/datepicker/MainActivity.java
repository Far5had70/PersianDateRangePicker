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
        PersianDateRangePicker persianDateRangePicker = new PersianDateRangePicker()
                .setInitTillDate(InitDate.inputPersianDate(1, 3, 1397))
                .setInitFromDate(InitDate.inputPersianDate(1, 1, 1397))
                .setBackgroundColor(getResources().getColor(R.color.green))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white_smoke))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setWheelTextSize(9)
                .setTypeface(face)
                .setDoneText("تائید")
                .setCanselText("انصراف")
                .setDoneDrawable(getResources().getDrawable(R.drawable.ic_tick))
                .setCanselDeawable(getResources().getDrawable(R.drawable.ic_mult))
                .setCurrentItem(SetCurrentItem.From)
                .setListener(new PersianDateRangePicker.RangeDate() {
                    @Override
                    public void From(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, ""+day+"  "+month+"  "+year, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void TillDate(int day, int month, int year) {
                        Toast.makeText(MainActivity.this, ""+day+"  "+month+"  "+year, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void cansel() {

                    }
                });
        persianDateRangePicker.show(fragmentManager, "PersianDateRangePicker");

    }

    private void datePicker() {

        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDatePicker persianDateRangePicker = new PersianDatePicker()
                .setInitFromDate(InitDate.inputPersianDate(1, 1, 1397))
                .setBackgroundColor(getResources().getColor(R.color.green))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setButtonTextColor(getResources().getColor(R.color.white_smoke))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setWheelTextSize(9)
                .setTypeface(face)
                .setDoneText("تائید")
                .setCanselText("انصراف")
                .setDoneDrawable(getResources().getDrawable(R.drawable.ic_tick))
                .setCanselDeawable(getResources().getDrawable(R.drawable.ic_mult))
                .setListener(new PersianDatePicker.PickDate() {
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
