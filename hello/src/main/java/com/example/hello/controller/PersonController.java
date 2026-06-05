package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hello.models.Person;


@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @GetMapping("/get")
    public String person(Model model) {
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("P1");

        model.addAttribute("p", p1);

        return "person";
    }

    @GetMapping("/list")
    public String personList() {
        return "person-list";
    }
    
    
}
