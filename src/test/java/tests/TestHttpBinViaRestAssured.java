package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class TestHttpBinViaRestAssured extends BaseTest {

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testGetRequestWithStatusCodeReturnThisStatus(String endPoint, int statusCode) {
        given()
                .spec(rspec)
                .get(endPoint)
                .then()
                .assertThat()
                .statusCode(statusCode);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testPostRequestWithStatusCodeReturnThisStatus(String endPoint, int statusCode) {
        given()
                .spec(rspec)
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(statusCode);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("/status/200", 200),
                Arguments.of("/status/300", 300),
                Arguments.of("/status/400", 400),
                Arguments.of("/status/500", 500)
        );
    }
}

