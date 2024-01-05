package com.avi.movies.servcie;

import com.avi.movies.model.Movie;
import com.avi.movies.model.Reviews;
import com.avi.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private MongoTemplate mongoTemplate ;


    @Autowired
    private ReviewRepository reviewRepository;
    public Reviews createReview(String reviewbody, String ImdbID){
       Reviews reviews =  reviewRepository.insert(new Reviews(reviewbody));

       mongoTemplate.update(Movie.class).matching(Criteria.where("imdbid").is(ImdbID))
                .apply(new Update().push("reviews").value(reviews)).first();

       return reviews;
    }
}
