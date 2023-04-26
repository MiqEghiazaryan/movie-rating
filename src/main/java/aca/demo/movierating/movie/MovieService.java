package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component

public class MovieService {

    private final MovieRepository movieRepository;


    public Movie getById(Long id){
        log.debug("MovieService getting by id:{}",id);
        return movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie Not Found"));

    }

    public List<Movie> search(Genre genre, String title, LocalDate releasedBefore,LocalDate releasedAfter) {
        log.debug("Searching for movies by genre: {}",genre);
        return movieRepository.search(genre,title,releasedBefore,releasedAfter);

    }

    public void create(CreateMovie createMovie) {
        log.debug("Creating movie: {}", createMovie);
        String title = createMovie.getTitle();
        if (movieRepository.findById(createMovie.getId()).isPresent()) {
            throw new IllegalArgumentException("Movie with title " + title + " already exists");
        }
        movieRepository.persist(new Movie(createMovie));

    }

    void update(Long id, UpdateMovie updateMovie) {
        log.debug("MovieService updateing:{}",updateMovie);
        Movie movie = getById(id);
        if (movie == null) {
            throw new MovieNotFoundException("Movie not Found");
        } else {
            movie.update(updateMovie);
        }
    }

    void delete(Long id) {
        Movie movie = getById(id);
        if(movie == null){
            throw new MovieNotFoundException("Movie not Found");
        }else{
            movieRepository.delete(movie);
        }

    }
}
