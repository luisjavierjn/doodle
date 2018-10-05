package com.doodle.examluis.domain.service;

import com.doodle.examluis.domain.dto.PollDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component("pollService")
public class PollServiceImpl implements IPollService {
    @Override
    public void add(PollDTO aPollDTO) {

    }

    @Override
    public void addMulti(List<PollDTO> arrPollDTO) {

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
