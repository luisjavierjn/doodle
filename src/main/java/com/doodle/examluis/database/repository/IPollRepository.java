package com.doodle.examluis.database.repository;

import com.doodle.examluis.database.document.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPollRepository extends MongoRepository<Poll, String> {
}
