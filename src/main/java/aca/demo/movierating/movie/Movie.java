package aca.demo.movierating.movie;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;


@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Slf4j
@AllArgsConstructor


public class Movie {

    @EqualsAndHashCode.Include
    Long id;

    String title;
    Genre genre;

    LocalDate releasedAt;

    String director;

    double rating;


    Movie(CreateMovie createMovie) {
        log.debug("Constructing movie with createMovie - {}",createMovie);
    }

    void update(UpdateMovie updateMovie){
        log.debug("Updating movie with updateMovie - {}",updateMovie);

        this.id = updateMovie.getId();
        this.title = updateMovie.getTitle();
        this.genre = updateMovie.getGenre();
        this.director = updateMovie.getDirector();
        this.rating = updateMovie.getRating();
    }


}
