# Persian Date Range Picker

<img src="https://raw.githubusercontent.com/Far5had70/PersianDateRangePicker/master/screen-record.gif" height="480" width="270">

 PersianDateRangePicker is a dynamic library that allows user to select a date range.

# Features

Background (color)

Text (size , color)

TypeFace(directory: Assets/sampleFont.ttf)



# Installation

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	dependencies {
	        implementation 'com.github.Far5had70:PersianDateRangePicker:1.1.0'
	}
	
Step 2. Add the dependency

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



# Usage

        Typeface face = Typeface.createFromAsset(getAssets(), "bsans.ttf");
        FragmentManager fragmentManager = getSupportFragmentManager();
        PersianDateRangePicker persianDateRangePicker = new PersianDateRangePicker(
                InitDate.inputPersianDate(1 , 1 , 1397) ,  // InitFromDate
                InitDate.inputPersianDate(1 , 7 , 1397) ,  // Init Till Date
                getResources().getColor(R.color.green) ,  // Background Color
                getResources().getColor(R.color.white) ,  // Button Text Color
                getResources().getColor(R.color.white) ,  // Tab Text Color
                getResources().getColor(R.color.white) ,  // Tab Selected Text Color
                getResources().getColor(R.color.white) ,  // Tab Indicator Color
                getResources().getColor(R.color.white_smoke) ,  // Wheel Text Color
                getResources().getColor(R.color.white) ,  // Wheel Text Color Selected
                20 ,  // Wheel Text Size
                face ,  // type face
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
       


# Developed By

Farshad Asgharzadeh

For contact, shoot me an email at ferik800@gmail.com
