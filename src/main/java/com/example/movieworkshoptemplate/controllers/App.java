package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.Database;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class App {

    Database database = new Database();
    int test2;
    @GetMapping("/")
    public String index() {
        return "index";
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


