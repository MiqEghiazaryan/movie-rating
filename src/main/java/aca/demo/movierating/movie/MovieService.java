package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component

public class MovieService {

    private final MovieRepository movieRepository;



    public List<Movie> search(Genre genre) {
        log.debug("Searching for movies by genre: {}",genre);
        return movieRepository.findByGenre(genre);

    }

    public void create(CreateMovie createMovie) {
        log.debug("Creating movie: {}", createMovie);
        String title = createMovie.getTitle();
        if (movieRepository.findByTitle(title).isPresent()) {
            throw new IllegalArgumentException("Movie with title " + title + " already exists");
        }
        movieRepository.save(createMovie);

    }
}
