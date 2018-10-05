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
public class InitiatorDTO implements Serializable {

    private static final long serialVersionUID = 4563008729222822607L;

    String name;
    String email;
    boolean notify;
    String timeZone;
}
