package com.doodle.examluis.database.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Initiator {

    String name;
    String email;
    boolean notify;
    String timeZone;
}
