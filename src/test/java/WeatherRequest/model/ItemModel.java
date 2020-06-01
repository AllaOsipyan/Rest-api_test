package WeatherRequest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemModel {


    @JsonProperty(value = "data")
    List <WeatherDataModel> weatherDataModel;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonProperty(value = "count")
    int count;
    public List<WeatherDataModel> getWeatherDataModel() {
        return weatherDataModel;
    }

    public void setWeatherDataModel(List<WeatherDataModel> weatherDataModel) {
        this.weatherDataModel = weatherDataModel;
    }
}
