package com.example.movieworkshoptemplate.controllers;

import java.util.ArrayList;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    MovieService service = new MovieService();


    //Controller methods
    @GetMapping("/")
    public String index() {
        return "Hello World welcome to my application";
    }


    @GetMapping("/getfirst")
    public String first () {
        return service.getfirst();
    }


    @GetMapping("/getTenSortByPopularity")
    public ArrayList<String> tenPopularity() {
        return service.getTenSortByPopularity();
    }

    @GetMapping("/getrandom")
    public String random() {
        return service.getRandom();
    }

    @GetMapping("/howManyWonAnAward")
    public int awardCount() {
        return service.countAward();
    }
}


