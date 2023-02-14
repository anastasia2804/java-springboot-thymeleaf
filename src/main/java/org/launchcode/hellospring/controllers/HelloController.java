package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

        //Handles request of the form /hello?name=LaunchCode
        @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
        public String helloWithQueryParam(@RequestParam String name, Model model) {
           String greeting = "Hello, " + name + "!";
           model.addAttribute("greeting", greeting);
           return "hello";
            }

        //Handles requests of the form /hello/LaunchCode
        @GetMapping("hello/{name}")
        public String helloWithPathParam(@PathVariable String name, Model model){
            String greeting = "Hello, " + name + "!";
            model.addAttribute("greeting", greeting);
            return "hello";
        }

        @GetMapping("form")
        public String helloForm() {
            return "form";
        }
        @GetMapping("hello-list")
        public String helloNames(Model model) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(144);
            numbers.add(-45);
            numbers.add(25);
            model.addAttribute("numbers", numbers);
            return "hello-list";
        }

}
