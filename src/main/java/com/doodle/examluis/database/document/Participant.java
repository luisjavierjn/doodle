package com.doodle.examluis.database.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Participant {

    long id;
    String name;
    int[] preferences;
}
