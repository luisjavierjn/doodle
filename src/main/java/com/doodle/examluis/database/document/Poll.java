package com.doodle.examluis.database.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "polls")
@CompoundIndex(def = "{'$**':'text'}") // '$**':'text' can cause a performance hit
public class Poll {

    @Id
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
    Initiator initiator;
    Option[] options;
    String optionsHash;
    Participant[] participants;
    Invitees[] invitees;
    boolean dateText;
    boolean multiDay;
    String device;
    String levels;
}
