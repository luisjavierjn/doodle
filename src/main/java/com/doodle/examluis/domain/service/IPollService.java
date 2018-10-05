package com.doodle.examluis.domain.service;

import com.doodle.examluis.domain.dto.PollDTO;

import java.util.Collection;
import java.util.List;

public interface IPollService {
    void add(PollDTO aPollDTO);

    void addMulti(List<PollDTO> arrPollDTO);

    Collection<PollDTO> get();

    Collection<PollDTO> getPollsInitiatedSince(String aCreationDate);

    Collection<PollDTO> getTextSearch(String aCriteria);

    void del();
}
