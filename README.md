# Persian Date Range Picker

<img src="https://raw.githubusercontent.com/Far5had70/PersianDateRangePicker/master/capture.gif" height="480" width="270">

 PersianDateRangePicker is a dynamic library that allows user to select a date range.



# Features

Background (color)

Text (size , color)

TypeFace(directory: Assets/sampleFont.ttf)




# Installation

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

```gradle
	dependencies {
	        implementation 'com.github.Far5had70:PersianDateRangePicker:4.0.0'
	}
```


Step 2. Add the dependency
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```




## Demo

You can try it out here [Sample Application](https://github.com/Far5had70/PersianDateRangePicker/blob/master/app/src/main/java/com/shaygan/datepicker/MainActivity.java)




# Usage



**Date Range Picker:**

```java
        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDateRangePicker persianDateRangePicker = new PersianDateRangePicker()
                .setInitTillDate(InitDate.inputPersianDate(1, 3, 1397))
                .setInitFromDate(InitDate.inputPersianDate(1, 1, 1397))
                .setBackgroundColor(getResources().getColor(R.color.green))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setTabTextColor(getResources().getColor(R.color.white))
                .setTabSelectedTextColor(getResources().getColor(R.color.white))
                .setTabIndicatorColor(getResources().getColor(R.color.white))
                .setWheelTextColor(getResources().getColor(R.color.white_smoke))
                .setWheelTextColorSelected(getResources().getColor(R.color.white))
                .setWheelTextSize(9)
                .setCornerRadius(40)
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
```



**Date Picker:**

```java
        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDatePicker persianDateRangePicker = new PersianDatePicker()
                .setInitFromDate(InitDate.inputPersianDate(1, 1, 1397))
                .setBackgroundColor(getResources().getColor(R.color.green))
                .setButtonTextColor(getResources().getColor(R.color.white))
                .setTabTextColor(getResources().getColor(R.color.white))
                .setTabSelectedTextColor(getResources().getColor(R.color.white))
                .setTabIndicatorColor(getResources().getColor(R.color.white))
                .setWheelTextColor(getResources().getColor(R.color.white_smoke))
                .setWheelTextColorSelected(getResources().getColor(R.color.white))
                .setWheelTextSize(9)
                .setCornerRadius(40)
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
```




# Developed By

Farshad Asgharzadeh

For contact, shoot me an email at ferik800@gmail.com
