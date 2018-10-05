package com.doodle.examluis.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ParticipantDTO implements Serializable {

    private static final long serialVersionUID = 2788798664752689775L;

    long id;
    String name;
    int[] preferences;
}
