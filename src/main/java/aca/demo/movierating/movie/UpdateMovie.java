package aca.demo.movierating.movie;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;


@Value
@Builder
@Jacksonized

public class UpdateMovie {

    Long id;

    String title;

    Genre genre;

    LocalDate releasedAt;

    String director;

    double rating;
}
