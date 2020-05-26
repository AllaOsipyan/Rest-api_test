package WeatherRequest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemModel {


    @JsonProperty(value = "data")
        WeatherDataModel weatherDataModel;

    public WeatherDataModel getWeatherDataModel() {
        return weatherDataModel;
    }

    public void setWeatherDataModel(WeatherDataModel weatherDataModel) {
        this.weatherDataModel = weatherDataModel;
    }
}
