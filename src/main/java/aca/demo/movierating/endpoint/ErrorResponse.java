package aca.demo.movierating.endpoint;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor

public class ErrorResponse {

    int errorCode;
    String description;
    String field;


}
