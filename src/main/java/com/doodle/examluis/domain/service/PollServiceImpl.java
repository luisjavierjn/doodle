package com.doodle.examluis.domain.service;

import com.doodle.examluis.database.document.Poll;
import com.doodle.examluis.database.repository.IPollRepository;
import com.doodle.examluis.domain.dto.PollDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("pollService")
public class PollServiceImpl implements IPollService {

    @Autowired
    private IPollRepository pollRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    public PollDTO convertToDto(Poll aPoll) {
        return modelMapper.map(aPoll, PollDTO.class);
    }

    public Poll convertToDocument(PollDTO aPollDTO) {
        return modelMapper.map(aPollDTO, Poll.class);
    }

    @Override
    public void add(PollDTO aPollDTO) {
        pollRepository.save(convertToDocument(aPollDTO));
    }

    @Override
    public void addMulti(List<PollDTO> arrPollDTO) {
        List<Poll> arrPoll = arrPollDTO.stream().map(this::convertToDocument).collect(Collectors.toList());
        pollRepository.saveAll(arrPoll);
    }

    @Override
    public Collection<PollDTO> get() {
        List<Poll> arrPoll = pollRepository.findAll();
        return arrPoll.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Collection<PollDTO> getFilterByCreationDate(String aCreationDate) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(aCreationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!Optional.ofNullable(date).isPresent()) {
            return new ArrayList<>();
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("initiated").gt(date.getTime()));
        List<Poll> arrPoll = mongoTemplate.find(query, Poll.class);
        return arrPoll.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Collection<PollDTO> getTextSearch(String aCriteria) {
        Stream<Poll> arrPoll = pollRepository.findPoll(aCriteria,pollRepository.TEXT_SCORE_SORT);
        return arrPoll.map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void del() {
        pollRepository.deleteAll();
    }
}
