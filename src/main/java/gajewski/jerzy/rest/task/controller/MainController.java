package gajewski.jerzy.rest.task.controller;

import gajewski.jerzy.rest.task.model.Numbers;
import gajewski.jerzy.rest.task.service.NumberService;
import gajewski.jerzy.rest.task.service.PongService;
import gajewski.jerzy.rest.task.wrapper.NumberWrapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/")
public class MainController {

    private final PongService pongService;
    private final NumberService numberService;

    public MainController(PongService pongService, NumberService numberService) {
        this.pongService = pongService;
        this.numberService = numberService;
    }

    @GetMapping("/status/ping")
    public String getPong(){
        return pongService.getPong();

    }

    @PostMapping("/numbers/sort-command")
    public Numbers numberSortedList(@Valid @RequestBody NumberWrapper numberWrapper){
        return numberService.sortNumbers(numberWrapper);
    }
}
