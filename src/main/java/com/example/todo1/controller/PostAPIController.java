package com.example.todo1.controller;

import com.example.todo1.model.Element;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostAPIController {

    // HTTP 통신을 할 때 POST는 body에 데이터를 넣어 보낸다.
    // @RequestBody에 Element에 있는 값을 매칭해서 보내라.
    @RequestMapping(method = RequestMethod.POST, path = "/postRequest")
    public Element postRequest(@RequestBody Element element) {
        return element;
    }

    @PostMapping(value = "/postMapping")
    public Element postMapping(@RequestBody Element element) {
        return element;
    }
}
