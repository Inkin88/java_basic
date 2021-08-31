package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    protected RequestSpecification rspec;
    protected RequestSpecBuilder build;

    protected BaseTest() {
        build = new RequestSpecBuilder();
        build.setBaseUri("https://httpbin.org");
        rspec = build.build();
    }
}
