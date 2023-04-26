package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Component
@Slf4j

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();


    public Optional<Movie> findById(Long id) {
        log.debug("Finding movie by Id: {}", id);
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    public void persist(Movie movie) {
        log.debug("Creating movie: {}", movie);
        movie = new Movie(movie.getId(), movie.getTitle(), movie.getGenre(),movie.releasedAt, movie.getDirector(), movie.getRating());
        movies.add(movie);

    }

    void delete(Movie movie) {
        log.debug("Delete Movie: {}", movie);
        var movie1 = findById(movie.getId());
        movie1.ifPresent(value -> movies.remove(value));

    }

    List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
        log.debug("Find Movie by genre:{} , title:{} , releasedBefore:{} , releasedAfter:{}", genre, title, releasedBefore, releasedAfter);
        Stream<Movie> movieStream = movies.stream();

        if (genre != null) {
            movieStream.filter(movie -> movie.getGenre().equals(genre));
        }

        if (title != null) {
            movieStream.filter(movie -> movie.getTitle().equals(title));
        }

        if (releasedBefore != null) {
            movieStream.filter(movie -> movie.getReleasedAt().isBefore(releasedBefore));
        }

        if (releasedAfter != null) {
            movieStream.filter(movie -> movie.getReleasedAt().isAfter(releasedAfter));
        }

        return movieStream.toList();
    }

}
