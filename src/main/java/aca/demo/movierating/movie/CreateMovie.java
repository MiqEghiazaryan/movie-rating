package aca.demo.movierating.movie;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized

public class CreateMovie {

    Long id;
    String title;
    Genre genre;

    LocalDate releasdAat;

    String director;

    double rating;


}
