package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

    @JsonProperty("Message")
    private String message;
    @JsonProperty("patient")
    private int patient;
    @JsonProperty("helthstatus")
    private String helthstatus;
}
