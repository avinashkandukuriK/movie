package com.avi.movies.repository;

import com.avi.movies.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieByImdbId(String Imdb);

    Optional<Movie> findMovieByTitle(String Title);

    Optional<List<Movie>> findMovieByGenres(String genres);
}
