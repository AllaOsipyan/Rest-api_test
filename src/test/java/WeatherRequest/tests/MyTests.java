package WeatherRequest.tests;

import WeatherRequest.model.ItemModel;
import WeatherRequest.model.WeatherDataModel;
import WeatherRequest.service.WeatherDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MyTests extends BaseTest{
    @Test(groups = "test")
    public void checkCityParam(){
        WeatherDataService weatherDataService = new WeatherDataService(properties);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        Date date = new Date();
        String cityName = "London";
        RequestSpecification requestSpecification = weatherDataService.requestBuilder()
                .getFields("data", "count")
                .setCityParam(cityName)
                .build();
        ValidatableResponse validatableResponse = weatherDataService.executeGetDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("data.city_name", everyItem(containsString(cityName)))
                .body("data.ob_time", everyItem(containsString(""+df.format(date))))
                .body("count", equalTo(1));
    }

    @Test(groups = "models")
    public void getDatasetId() {
        double latitude = 38.12;
        double longitude = -78.54;
        WeatherDataService weatherDataService = new WeatherDataService(properties);
        RequestSpecification requestSpecification = weatherDataService.requestBuilder()
                .getFields("data")
                .setLatitudeParam(latitude)
                .setLongitudeParam(longitude)
                .build();
        ItemModel dataset = weatherDataService.getDatasets(requestSpecification);

        assertThat(dataset.getWeatherDataModel().get(0).getLongitude(), equalTo(longitude));
        assertThat(dataset.getWeatherDataModel().get(0).getLatitude(), equalTo(latitude));

    }


    @Test(groups = "test")
    public void deleteItem(){

        WeatherDataService weatherDataService = new WeatherDataService(properties);
        RequestSpecification requestSpecification = weatherDataService.requestBuilder()
                .setLatitudeParam(15)
                .setLongitudeParam(-78.543)
                .build();
        ValidatableResponse validatableResponse = weatherDataService.executeDeleteDatasets(requestSpecification)
                .then()
                .statusCode(403);
    }
}
