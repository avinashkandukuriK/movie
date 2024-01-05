package com.avi.movies.servcie;

import com.avi.movies.model.Movie;
import com.avi.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allmovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> moviesbyimdb(String ImdbId){
        return movieRepository.findMovieByImdbId(ImdbId);
    }

    public Optional<Movie> moviesbytitle(String title){
        return movieRepository.findMovieByTitle(title);
    }

    public Optional<List<Movie>> moviesbygenres(String genres){
        return movieRepository.findMovieByGenres(genres);
    }
}
