package cryptoplace_backend.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("x-cg-demo-api-key", "CG-Tre61KMbvbNVRAa97p4Ao8hg");
        return headers;
    }

    public Object getAllCoins(String currency) {
        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + currency;

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class).getBody();
    }

    public Object getCoinData(String coinId) {
        String url = "https://api.coingecko.com/api/v3/coins/" + coinId;

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class).getBody();
    }

    public Object getHistoricalData(String coinId, String currency) {
        String url = "https://api.coingecko.com/api/v3/coins/" + coinId +
                "/market_chart?vs_currency=" + currency + "&days=10&interval=daily";

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class).getBody();
    }
}