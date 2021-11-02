package com.example.demo.controllers;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.utility.Database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/create")
    public String postCreate(@RequestParam MultiValueMap body) {
        return "";
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

