package khader.shaik.io.openweatherapp;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mockito;

import khader.shaik.io.openweatherapp.data.binding.SearchFields;
import khader.shaik.io.openweatherapp.data.model.Weather;
import khader.shaik.io.openweatherapp.ui.list.WeatherListViewModel;

import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    MutableLiveData<Weather> weatherMutableLiveData = new MutableLiveData<Weather>();
    private final MutableLiveData<Boolean> weatherDataLoadError = new MutableLiveData<>();
    private final MutableLiveData<SearchFields> searchFieldsMutableLiveData = new MutableLiveData<>();



    @Test
    public void testGetWeather(){
        WeatherListViewModel weatherListViewModel = Mockito.mock(WeatherListViewModel.class);
        Mockito.when(weatherListViewModel.getWeather()).thenReturn(weatherMutableLiveData);
        MutableLiveData<Weather> weatherMutableLiveData  = weatherListViewModel.getWeather();
        assertNotNull(weatherMutableLiveData);
    }

    @Test
    public void testGetWeatherObserverValue(){
        WeatherListViewModel weatherListViewModel = Mockito.mock(WeatherListViewModel.class);
        Mockito.when(weatherListViewModel.getWeather()).thenReturn(weatherMutableLiveData);
        MutableLiveData<Weather> weatherMutableLiveData  = weatherListViewModel.getWeather();
        weatherMutableLiveData.observeForever(new Observer<Weather>() {
            @Override
            public void onChanged(@Nullable Weather weather) {
                assertNotNull(weather);
            }
        });
        weatherMutableLiveData.postValue(Mockito.mock(Weather.class));
    }

    @Test
    public void testDataLoadError(){
        WeatherListViewModel weatherListViewModel = Mockito.mock(WeatherListViewModel.class);
        Mockito.when(weatherListViewModel.getError()).thenReturn(weatherDataLoadError);
        LiveData<Boolean> loadingBooleanLiveData  = weatherListViewModel.getError();
        loadingBooleanLiveData.observeForever(aBoolean -> {
            Assert.assertEquals(aBoolean,false);
        });
        ((MutableLiveData)loadingBooleanLiveData).setValue(false);
    }

    @Test
    public void testSearchFields(){
        WeatherListViewModel weatherListViewModel = Mockito.mock(WeatherListViewModel.class);
        Mockito.when(weatherListViewModel.getSearchFields()).thenReturn(searchFieldsMutableLiveData);
        MutableLiveData<SearchFields> searchFieldsMutableLiveData  = weatherListViewModel.getSearchFields();
        searchFieldsMutableLiveData.observeForever(new Observer<SearchFields>() {
            @Override
            public void onChanged(@Nullable SearchFields searchFields) {
                assertNotNull(searchFields);
                Assert.assertEquals("Delhi,IN",searchFields.getSearchText());
            }
        });
        SearchFields searchFields = Mockito.mock(SearchFields.class);
        Mockito.when(searchFields.getSearchText()).thenReturn("Delhi,IN");
        searchFieldsMutableLiveData.setValue(searchFields);
    }
}