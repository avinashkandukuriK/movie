package com.avi.movies.repository;

import com.avi.movies.model.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ReviewRepository extends MongoRepository<Reviews, ObjectId> {
}
