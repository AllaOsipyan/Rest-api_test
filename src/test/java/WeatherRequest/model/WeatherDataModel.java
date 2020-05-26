package WeatherRequest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataModel {



    @JsonProperty(value = "lon")
    double longitude;
    @JsonProperty(value = "lat")
    double latitude;
    @JsonProperty(value = "ob_time")
    String obTime;
    @JsonProperty(value = "city_name")
    String cityName;

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setObTime(String obTime) {
        this.obTime = obTime;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }




    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getObTime() {
        return obTime;
    }

    public String getCityName() {
        return cityName;
    }
}
