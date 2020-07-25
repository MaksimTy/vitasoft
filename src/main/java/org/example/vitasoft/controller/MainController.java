package org.example.vitasoft.controller;

import org.example.vitasoft.domain.Months;
import org.example.vitasoft.domain.StringsSorter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    private StringsSorter stringsSorter;

    @GetMapping
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/month")
    public String month(
            @RequestParam(name = "monthNumber", required = false, defaultValue = "1") int monthNumber,
            Map<String, Object> model) {

        String monthName = Months.getName(monthNumber);
        model.put("monthNumber", monthNumber);
        model.put("monthName", monthName);
        return "month";
    }

    @PostMapping("/strings")
    public String strings(
            @RequestParam String inputs,
            Map<String, Object> model) {
        {
            if (inputs != null && !inputs.isEmpty()) {
                String[] lines = inputs.split("\r\n");
                stringsSorter = new StringsSorter(lines);
                stringsSorter.sort();
                stringsSorter.setJsonObject();

                model.put("jsonarray", stringsSorter.getJsonArray().toList());
                model.put("inputs", inputs);
                model.put("isexist", true);
            } else {
                model.put("jsonarray", "");
                model.put("inputs", "");
                model.put("isexist", false);
            }
        }
        return "strings";
    }


    @GetMapping("/strings")
    public String some(
            Map<String, Object> model) {
        model.put("inputs", "");
        model.put("jsonarray", "");
        model.put("isexist", false);

        return "strings";
    }
}