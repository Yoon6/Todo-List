package com.example.todo1.controller;

import com.example.todo1.model.Element;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")// localhost:8080/api
public class GetAPIController {

    // localhost:8080/api/getRequest
    @RequestMapping(method = RequestMethod.GET, path = "/getRequest")
    public String getRequest() {
        return "this is getRequest";
    }

    // GetMapping - 메소드 유형 없이 주소만 지정
    // localhost:8080/api/getParameters?id=yoon&email=yoonda5898@gmail.com
    @GetMapping("/getParameters")
    public String getParameters(@RequestParam String id, @RequestParam String email) {
        return "아이디는 " + id + " 이메일은 " + email;
    }

    // localhost:8080/api/getMultiParameters?content=yoonda5898@gmail.com
    @GetMapping("/getMultiParameters")
    public String getMultiParameters(Element element) {
        return "id = " + element.getId() + " content = " + element.getContent();
    }

    // json 형식으로 받기
    // localhost:8080/api/getMultiParametersRtnJson?content=yoonda5898@gmail.com
    @GetMapping("/getMultiParametersRtnJson")
    public Element getMultiParametersRtnJson(Element element) {
        return element;
    }

    // json 형식으로 받기
    // localhost:8080/api/getRequestJson?content=yoonda5898@gmail.com
    @RequestMapping(method = RequestMethod.GET, path = "/getRequestJson")
    public Element getRequestJson(Element element) {
        return element;
    }
}
