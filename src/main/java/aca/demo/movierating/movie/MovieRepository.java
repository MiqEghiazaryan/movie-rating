package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();

      public Optional<Movie> findByTitle(String title) {
          log.debug("Finding movie by title: {}", title);
          return movies.stream()
                  .filter(movie -> movie.getTitle().equals(title))
                  .findFirst();
    }

    public List<Movie> findByGenre(Genre genre) {
        log.debug("Finding movies by genre: {}", genre);
        return movies.stream()
                .filter(movie -> movie.getGenre() == genre)
                .toList();
    }

    public void save(CreateMovie createMovie) {
        log.debug("Creating movie: {}", createMovie);
        Movie movie = new Movie(createMovie.getId(),createMovie.getTitle(), createMovie.getGenre(),createMovie.getDirector(),createMovie.getRating());
        movies.add(movie);
    }
}
