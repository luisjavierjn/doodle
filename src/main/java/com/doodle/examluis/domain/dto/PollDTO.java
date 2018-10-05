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
public class PollDTO implements Serializable {

    private static final long serialVersionUID = 4296021399269863637L;

    String id;
    String adminKey;
    long latestChange;
    long initiated;
    int participantsCount;
    int inviteesCount;
    String type;
    boolean timeZone;
    int rowConstraint;
    int columnConstraint;
    boolean hidden;
    String preferencesType;
    String state;
    String locale;
    String title;
    String description;
    InitiatorDTO initiator;
    OptionDTO[] options;
    String optionsHash;
    ParticipantDTO[] participants;
    InviteesDTO[] invitees;
    boolean dateText;
    boolean multiDay;
    String device;
    String levels;
}
