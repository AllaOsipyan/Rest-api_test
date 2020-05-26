package WeatherRequest.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BaseService {
    private RequestSpecification requestSpecification;
    public BaseService(Properties properties){
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(properties.getProperty("base_uri"))
                .setBasePath(properties.getProperty("base_path"))
                .addQueryParam("key", properties.getProperty("api_key"));

        boolean devEnvironment = Boolean.parseBoolean(properties.getProperty("dev","false"));
        if(devEnvironment){
            specBuilder.addFilter(new ResponseLoggingFilter())
                    .addFilter(new RequestLoggingFilter());
        }

        requestSpecification = specBuilder.build();
    }

    protected RequestSpecification baseRequest() {
        return given().spec(requestSpecification);
    }
}
