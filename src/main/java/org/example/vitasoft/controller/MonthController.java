package org.example.vitasoft.controller;

import org.example.vitasoft.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {

    private final MonthService service;

    @Autowired
    public MonthController(MonthService service) {
        this.service = service;
    }

    @GetMapping("/month")
    public String checkMonthName(@RequestParam(value = "id") String id){
        return service.getOutput(id);
    }
}
