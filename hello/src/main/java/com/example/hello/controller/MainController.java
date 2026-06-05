package com.example.hello.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.hello.models.Employee;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
;

@Controller
public class MainController {

    public static List<Employee> employees = new ArrayList<Employee>();

    @Autowired
    Environment environment;

    @GetMapping(value = "/")
    public String home(HttpServletRequest request){
        employees.addAll(Arrays.asList(new Employee(1, "A", 50), new Employee(2,"B",60), new Employee(3,"C",25)));
        request.setAttribute("msg", environment.getProperty("message"));
        return "index";
    }

    @GetMapping(value = "/employee")
    public String employee(HttpServletRequest request, Model model){
        request.setAttribute("employees", employees);
        model.addAttribute("employee", new Employee(1,"Demo",23));
        return "employee";
    }

    // @PostMapping(value = "/employee")
    // public String addEmployee(HttpServletRequest request, @RequestParam(name = "name", required = true) String name,@RequestParam(name = "age", required = true) int age ) {
    //     employees.add(new Employee(employees.size()+1 ,name, age));
    //     return "redirect:/employee";
    // }

    @PostMapping(value = "/employee")
    public String addEmployee(HttpServletRequest request, @ModelAttribute(name = "employee") Employee employee ) {
        employee.setId(employees.size()+1);
        employees.add(employee);
        return "redirect:/employee";
    }
    
}
