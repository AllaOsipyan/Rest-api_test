package WeatherRequest.builder;

import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestBuilder {
    private RequestSpecification requestSpecification;

    public RequestBuilder(RequestSpecification requestSpecification){
        this.requestSpecification = requestSpecification;
    }

    public RequestBuilder setCityParam(String city){
        requestSpecification.queryParam("city",city);
        return this;
    }

    public RequestBuilder setLatitudeParam(double latitude){
        requestSpecification.queryParam("lat", latitude);
        return this;
    }

    public RequestBuilder setLongitudeParam(double longitude){
        requestSpecification.queryParam("lon", longitude);
        return this;
    }

    public RequestBuilder setLanguageParam(String language){
        requestSpecification.queryParam("lang", language);
        return this;
    }

    public RequestBuilder setUnits(String units){
        requestSpecification.queryParam("units", units);
        return this;
    }

    public RequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }
}