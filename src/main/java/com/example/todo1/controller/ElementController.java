package com.example.todo1.controller;

import com.example.todo1.model.Element;
import com.example.todo1.service.ElementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElementController {

    private final ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    // 시작페이지
    @GetMapping("/")
    public String home(Model model) {

        List<Element> elements = elementService.findAll();
        model.addAttribute("elements", elements);

        return "home";
    }

    // home.html -> Post 요청
    @PostMapping("/addElement")
    public String addElement(ElementForm form) {

        Element element = new Element();
        element.setContent(form.getContent());

        elementService.save(element);

        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteElement(ElementForm form) {

        elementService.deleteById(form.getId());

        return "redirect:/";
    }
}
