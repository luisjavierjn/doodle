package com.doodle.examluis.database.repository;

import com.doodle.examluis.database.document.Poll;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface IPollRepository extends MongoRepository<Poll, String> {

    Sort TEXT_SCORE_SORT = new Sort(Sort.Direction.DESC, "score");

    @Query("{$text: {$search: ?0}}")
    Stream<Poll> findPoll(String aCriteria, Sort aSort);
}
