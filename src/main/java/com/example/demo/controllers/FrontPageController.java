package com.example.demo.controllers;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.utility.Database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FrontPageController {

    Database database = new Database();
    
    @GetMapping("/")
    public String index() {
        return "root";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/view")
    public String view(@RequestParam String id){
        // Brugt til at se en liste som ejer
        System.out.println(id);
        return "success";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam MultiValueMap body, RedirectAttributes redirectAttrs) {
        String name = String.valueOf(body.get("name"));
        String description = String.valueOf(body.get("description"));

        // TODO database kald der returnere id
        String result = database.createWishList(name, description);

        if (result == "400") {
            System.out.println("Failed to create " + name);
            return "fail";
        }

        // Tilføjer attributter 
        redirectAttrs.addAttribute("id", "2");
        return "redirect:/view?id={id}";

    }

    @PostMapping ("/edit")
    public String updateWishList (@RequestParam String id, @RequestParam MultiValueMap body) {
        return "";
    }

    @GetMapping ("/share")
    public String shareWishList (@RequestParam String id){
        return "share";
    }

    @DeleteMapping ("/delete")
    public String delete (@RequestParam String id) {
        return "";
    }






}

