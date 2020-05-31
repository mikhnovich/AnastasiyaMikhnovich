package hw9.service;

import hw9.utils.GetProperty;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SpellerService {

    public RequestSpecification requestSpec;

    public GetProperty property = new GetProperty();

    public SpellerService() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(getProperty("baseUri"))
                .addFilter(new RequestLoggingFilter())//  enable
                .addFilter(new ResponseLoggingFilter())// query logging
                .build();
    }

    public String getProperty(String propName) {
        try {
            return property.getProperty(propName);
        } catch (IOException e) {
            return null;
        }
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        return given(requestSpec)
                .params(params)
                .when()
                .get(uri);
    }
}
