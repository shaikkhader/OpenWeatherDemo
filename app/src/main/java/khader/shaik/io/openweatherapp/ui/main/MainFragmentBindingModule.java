/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import khader.shaik.io.openweatherapp.ui.list.WeatherMainFragment;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract WeatherMainFragment provideListFragment();

}
