package com.example.todo1.controller;

import com.example.todo1.model.Element;
import com.example.todo1.service.ElementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostAPIController {

    private final ElementService elementService;

    public PostAPIController(ElementService elementService) {
        this.elementService = elementService;
    }

    // HTTP 통신을 할 때 POST는 body에 데이터를 넣어 보낸다.
    // @RequestBody에 Element에 있는 값을 매칭해서 보내라.
    @RequestMapping(method = RequestMethod.POST, path = "/postRequest")
    public Element postRequest(@RequestBody Element element) {
        return element;
    }

    @PostMapping("/addElement")
    public String addElement(ElementForm form) {

        Element element = new Element();
        element.setContent(form.getContent());

        elementService.save(element);

        return "redirect:/";
    }

    @PostMapping(value = "/postMapping")
    public Element postMapping(@RequestBody Element element) {
        return element;
    }


}
