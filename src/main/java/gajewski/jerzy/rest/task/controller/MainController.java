package gajewski.jerzy.rest.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import gajewski.jerzy.rest.task.model.CurrencyValue;
import gajewski.jerzy.rest.task.model.Numbers;
import gajewski.jerzy.rest.task.service.CurrencyService;
import gajewski.jerzy.rest.task.service.NumberService;
import gajewski.jerzy.rest.task.service.PongService;
import gajewski.jerzy.rest.task.wrapper.CurrencyWrapper;
import gajewski.jerzy.rest.task.wrapper.NumberWrapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Validated
@RequestMapping("/")
public class MainController {

    private final PongService pongService;
    private final NumberService numberService;
    private final CurrencyService currencyService;

    public MainController(PongService pongService, NumberService numberService, CurrencyService currencyService) {
        this.pongService = pongService;
        this.numberService = numberService;
        this.currencyService = currencyService;
    }

    @GetMapping("/status/ping")
    public String getPong(){
        return pongService.getPong();

    }

    @PostMapping("/numbers/sort-command")
    public Numbers numberSortedList(@Valid @RequestBody NumberWrapper numberWrapper){
        return numberService.sortNumbers(numberWrapper);
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public CurrencyValue getCurrencyValue(@RequestBody CurrencyWrapper currency) throws JsonProcessingException {
        return currencyService.getCurrencyValue(currency.getCurrency());

    }
}
