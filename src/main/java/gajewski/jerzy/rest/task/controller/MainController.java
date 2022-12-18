package gajewski.jerzy.rest.task.controller;

import gajewski.jerzy.rest.task.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/status/ping")
    public String getPong(){
        return mainService.getPong();

    }
}
