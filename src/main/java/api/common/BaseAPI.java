package api.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
    protected static final String BASE_URL = "https://api.github.com";

    protected RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("User-Agent", "Mozilla/5.0")
                .build();
    }
}
