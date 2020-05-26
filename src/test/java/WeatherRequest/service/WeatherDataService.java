package WeatherRequest.service;

import WeatherRequest.builder.RequestBuilder;
import WeatherRequest.model.ItemModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import WeatherRequest.model.WeatherDataModel;


import java.util.Properties;

public class WeatherDataService extends BaseService{
    private static final String ENDPOINT = "/current";
    public WeatherDataService(Properties properties) {
        super(properties);
    }

    public RequestBuilder requestBuilder(){
        return new RequestBuilder(baseRequest());
    }

    public ItemModel[] getDatasets(RequestSpecification requestSpecification){
        return executeGetDatasets(requestSpecification)
                .then()
                .extract()
                .body().as(ItemModel[].class);
    }

    public Response executeGetDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.get(ENDPOINT);
    }
    public Response executeDeleteDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.delete(ENDPOINT);
    }
}
