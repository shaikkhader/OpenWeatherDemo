/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.main;

import android.os.Bundle;

import khader.shaik.io.openweatherapp.R;
import khader.shaik.io.openweatherapp.base.BaseActivity;
import khader.shaik.io.openweatherapp.ui.list.WeatherMainFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new WeatherMainFragment()).commit();
    }
}
