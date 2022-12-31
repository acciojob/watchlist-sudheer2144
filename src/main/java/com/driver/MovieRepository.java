package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {


    HashMap<String,Movie> movies=new HashMap<>();
    HashMap<String,Director> directors=new HashMap<>();
    HashMap<String, List<String>> pair=new HashMap<>();

    public void addMovie(Movie movie){
        String movieName=movie.getName();
        movies.put(movieName,movie);
    }

    public void addDirector(Director  director ){
        String directorName=director.getName();
        directors.put(directorName,director);
    }

    public void addPair(String movie,String director){
        List<String> movieList=new ArrayList<>();;
        if(pair.containsKey(director)) {
            movieList=pair.get(director);
        }
        movieList.add(movie);
        pair.put(director,movieList);
    }

    public Movie getMovie(String name){
        return movies.get(name);
    }

    public Director getDirector(String name){
        return directors.get(name);
    }

    public List<String> getListOfMovies(String director){
        return pair.get(director);
    }

    public List<String> getAllMovies(){
        return new ArrayList<>(movies.keySet());
    }

    public void deleteDirectorMovies(String director){
        List<String> movieNames=pair.get(director);
        for(String movieName:movieNames){
            if(movies.containsKey(movieName)){
                movies.remove(movieName);
            }
        }
        if(directors.containsKey(director)) {
            directors.remove(director);
        }
        pair.remove(director);
    }

    public void deleteAllDirectorsMovies(){
        for(String director:pair.keySet()) {
            List<String> movieNames = pair.get(director);
            for (String movieName : movieNames) {
                if (movies.containsKey(movieName)) {
                    movies.remove(movieName);
                }
            }
            pair=new HashMap<>();
            directors=new HashMap<>();
        }

    }

}
