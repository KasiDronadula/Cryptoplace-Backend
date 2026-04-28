package cryptoplace_backend.controller;

import cryptoplace_backend.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coins")
@CrossOrigin("*")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/markets")
    public Object getAllCoins(@RequestParam String currency) {
        return cryptoService.getAllCoins(currency);
    }

    @GetMapping("/{coinId}")
    public Object getCoin(@PathVariable String coinId) {
        return cryptoService.getCoinData(coinId);
    }

    @GetMapping("/{coinId}/history")
    public Object getHistory(
            @PathVariable String coinId,
            @RequestParam String currency) {
        return cryptoService.getHistoricalData(coinId, currency);
    }
}
