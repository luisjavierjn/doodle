package com.doodle.examluis.controller;

import com.doodle.examluis.domain.dto.PollDTO;
import com.doodle.examluis.domain.service.IPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/doodlepolls")
public class PollController {

    @Autowired
    @Qualifier("pollService")
    IPollService pollService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody PollDTO aPollDTO) {
        pollService.add(aPollDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addMulti", method = RequestMethod.POST)
    public ResponseEntity<?> addMulti(@RequestBody List<PollDTO> arrPollDTO) {
        pollService.addMulti(arrPollDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<PollDTO>> get() {
        Collection<PollDTO> arrPollDTO = pollService.get();
        return new ResponseEntity<>(arrPollDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/initiatedSince", method = RequestMethod.POST)
    public ResponseEntity<Collection<PollDTO>> getFilterByCreationDate(@RequestParam String aCreationDate) {
        Collection<PollDTO> arrPollDTO = pollService.getFilterByCreationDate(aCreationDate);
        return new ResponseEntity<>(arrPollDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/textSearch", method = RequestMethod.POST)
    public ResponseEntity<Collection<PollDTO>> getTextSearch(@RequestParam String aCriteria) {
        Collection<PollDTO> arrPollDTO = pollService.getTextSearch(aCriteria);
        return new ResponseEntity<>(arrPollDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> del() {
        pollService.del();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
