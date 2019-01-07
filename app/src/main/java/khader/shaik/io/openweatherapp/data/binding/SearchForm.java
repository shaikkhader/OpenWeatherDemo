/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.binding;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 *  Project           : OpenWeatherDemo
 *  File Name         : SearchForm
 *  Description       :
 *  Revision History  : version 1
 *  Date              : 1/6/19
 *  Original author   : Shaik Khader Basha
 *  Description       : Initial version
 *  
 */
public class SearchForm extends BaseObservable {

    private SearchFields searchFields = new SearchFields();

    private MutableLiveData<SearchFields> buttonClick = new MutableLiveData<>();

    @Bindable
    public boolean isValid() {
        boolean valid = isSearchTextValid(false);
        return true;
    }


    public MutableLiveData<SearchFields> getSearchFields() {
        return buttonClick;
    }

    public SearchFields getFields(){
        return searchFields;
    }


    public void onClick() {
        if (isValid()) {
            buttonClick.setValue(searchFields);
        }
    }

    public boolean isSearchTextValid(boolean searchText) {
        if (searchFields != null && searchFields.searchText != null && searchFields.searchText.length() > 3){
            return true;
        }
        return false;
    }
}
