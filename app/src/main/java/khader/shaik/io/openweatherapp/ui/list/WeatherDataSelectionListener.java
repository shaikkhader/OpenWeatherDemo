/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.list;


import khader.shaik.io.openweatherapp.data.model.Data;

public interface WeatherDataSelectionListener {

    void onDataSelected(Data data);
}
