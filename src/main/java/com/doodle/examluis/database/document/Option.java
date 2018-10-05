package com.doodle.examluis.database.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Option {

    String text;
    long start;
    long end;
    boolean allday;
    long date;
    long startDate;
    long endDate;
    long dateTime;
    long startDateTime;
    long endDateTime;
    boolean available;
}
