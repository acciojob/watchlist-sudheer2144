package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepo;
    
    public void addMovie(Movie student){
        movierepo.addMovie(student);
    }

    public void addDirector(Director teacher){
        movierepo.addDirector(teacher);
    }

    public void addPair(String student,String teacher){
        movierepo.addPair(student,teacher);
    }

    public Movie getMovie(String name){
        return movierepo.getMovie(name);
    }

    public Director getDirector(String name){
        return movierepo.getDirector(name);
    }

    public List<String> getListOfMovies(String teacher){
        return movierepo.getListOfMovies(teacher);
    }

    public List<String> getAllMovies(){
        return movierepo.getAllMovies();
    }

    public void deleteDirectorMovies(String teacher){
        movierepo.deleteDirectorMovies(teacher);
    }

    public void deleteAllDirectorsMovies() {
        movierepo.deleteAllDirectorsMovies();
    }
}
