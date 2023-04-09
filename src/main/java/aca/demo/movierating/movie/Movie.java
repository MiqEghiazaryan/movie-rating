package aca.demo.movierating.movie;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.beans.ConstructorProperties;

@Getter
@ToString
@EqualsAndHashCode
@Slf4j
@AllArgsConstructor


public class Movie {
    String title;
    Genre genre;

    Movie(CreateMovie createMovie) {
        log.debug("Constructing movie with createMovie - {}",createMovie);
    }


}
