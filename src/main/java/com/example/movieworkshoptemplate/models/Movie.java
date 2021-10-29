package com.example.movieworkshoptemplate.models;

import java.util.Comparator;

//Movie POJO
public class Movie implements Comparable<Movie>{

    int year;
    int length;
    String title;
    String subject;
    int popularity;
    boolean awards;

    public Movie(int year, int length, String title, String subject, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;

        if ( awards.equals("Yes") ) {
            this.awards = true;
        } else {
            this.awards = false;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }


    @Override
    public int compareTo(Movie o) {
        // TODO Auto-generated method stub
        return this.getPopularity() - o.getPopularity();
    }
}

