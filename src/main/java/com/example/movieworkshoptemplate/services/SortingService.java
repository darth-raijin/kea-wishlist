package com.example.movieworkshoptemplate.services;

import java.util.Comparator;

import com.example.movieworkshoptemplate.models.Movie;

public class SortingService implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getPopularity() - o2.getPopularity();
    }
    
}
