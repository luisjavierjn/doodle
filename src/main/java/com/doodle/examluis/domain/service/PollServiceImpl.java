package com.doodle.examluis.domain.service;

import com.doodle.examluis.database.document.Poll;
import com.doodle.examluis.domain.dto.PollDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component("pollService")
public class PollServiceImpl implements IPollService {

    @Autowired
    private ModelMapper modelMapper;

    public PollDTO convertToDto(Poll aPoll) {
        return modelMapper.map(aPoll, PollDTO.class);
    }

    public Poll convertToDocument(PollDTO aPollDTO) {
        return modelMapper.map(aPollDTO, Poll.class);
    }

    @Override
    public void add(PollDTO aPollDTO) {
        convertToDocument(aPollDTO);
    }

    @Override
    public void addMulti(List<PollDTO> arrPollDTO) {
        arrPollDTO.stream().map(this::convertToDocument).collect(Collectors.toList());
    }

    @Override
    public Collection<PollDTO> get() {
        return null;
    }

    @Override
    public Collection<PollDTO> getFilterByCreationDate(String aCreationDate) {
        return null;
    }

    @Override
    public Collection<PollDTO> getTextSearch(String aCriteria) {
        return null;
    }

    @Override
    public void del() {

    }


}
