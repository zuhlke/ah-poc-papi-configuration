package sapi;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 8080)
@Import({SapiClient.class, SapiClientConfiguration.class})
public class SapiClientTest {

    @Autowired
    private SapiClient<String> sapiClient;

    @After
    public void setUp() {
        WireMock.reset();
    }

    @Test
    public void itReturnsAllCreditCardsForAGivenCustomer_WhenCustomerHasCards() {
        String response = "[ \"jason\" ]";

        stubFor(get(urlEqualTo("/customer/1/balance")).willReturn(aResponse()
                .withBody(response)
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)));

        assertEquals(Collections.singletonList("jason"), sapiClient.get("http://localhost:8080/customer/1/balance").block());
    }
}