package com.example.todo1.controller;

import com.example.todo1.model.Element;
import com.example.todo1.service.ElementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    private final ElementService elementService;

    public HomeController(ElementService elementService) {
        this.elementService = elementService;
    }

    // 시작페이지
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String home(Model model){

        List<Element> elements = elementService.findAll();
        model.addAttribute("elements", elements);

        return "home";
    }
}
