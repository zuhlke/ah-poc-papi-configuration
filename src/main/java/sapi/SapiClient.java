package sapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.retry.Retry;

import java.time.Duration;
import java.util.List;

@Service
public class SapiClient<T> {

    private static final String API_ERROR = "Failed to get credit card balances";

    @Autowired
    private SapiProperties sapiProperties;

    @Autowired
    WebClient webClient;

    public Mono<List<T>> get(String url) {
        return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.error(new SapiApiException(API_ERROR + ": " + response.statusCode())))
                .bodyToMono(new ParameterizedTypeReference<List<T>>() {
                })
                .retryWhen(Retry.any()
                        .fixedBackoff(Duration.ofSeconds(sapiProperties.getBackoff()))
                        .retryMax(sapiProperties.getRetries()));
    }
}
