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
public class OptionDTO implements Serializable {

    private static final long serialVersionUID = -4569927406412030293L;

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
