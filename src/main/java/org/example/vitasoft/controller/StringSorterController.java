package org.example.vitasoft.controller;

import org.example.vitasoft.service.StringSorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StringSorterController {

    private static String TEST = "Тихо струится река серебристая,\n" +
            "В царстве вечернем зеленой весны.\n" +
            "Солнце садится за горы лесистые.\n" +
            "Рог золотой выплывает луны.";

    private StringSorterService service;

    @Autowired
    public void setService(StringSorterService service) {
        this.service = service;
    }

    @GetMapping("/sort")
    public ModelAndView inputStringList(
    ) {
        ModelAndView modelAndView = new ModelAndView("sort");
        modelAndView.addObject("inputs", TEST);
        return modelAndView;
    }

    @PostMapping("/sort")
    @ResponseBody
    public List<String> getSortedStrings(@ModelAttribute("inputs") String inputs) {
        return service.getSortedStrings(inputs.split("\n"));
    }
}
