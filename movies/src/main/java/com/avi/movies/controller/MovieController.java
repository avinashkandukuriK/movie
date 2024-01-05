package com.avi.movies.controller;

import com.avi.movies.model.Movie;
import com.avi.movies.servcie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allmovies(){
        return new ResponseEntity<List<Movie>>(movieService.allmovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbid}")
    public ResponseEntity<Optional<Movie>> getsinglemovie(@PathVariable String imdbid){
        return new ResponseEntity<Optional<Movie>>(movieService.moviesbyimdb(imdbid),  HttpStatus.OK);

    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<Optional<Movie>> getmoviebytitle(
            @RequestParam(name = "title", required = false) String title){
        if(title==null || title.isEmpty()){
            return new ResponseEntity<Optional<Movie>>(movieService.moviesbytitle(title),  HttpStatus.OK);
        }else{
            return new ResponseEntity<Optional<Movie>>(movieService.moviesbytitle(title),  HttpStatus.OK);
        }
    }

}
