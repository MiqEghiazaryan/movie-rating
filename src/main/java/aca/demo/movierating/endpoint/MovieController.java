package aca.demo.movierating.endpoint;


import aca.demo.movierating.movie.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("movies")

public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) {
        log.debug("getById() called with id = {}", id);
        Movie movie = movieService.getById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateMovie createMovie) {
        log.debug("create() called with createMovie = {}", createMovie);
        movieService.create(createMovie);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateMovie updateMovie) {
        log.debug("update() called with id = {} and updateMovie = {}", id, updateMovie);
        movieService.update(id, updateMovie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.debug("delete() called with id = {}", id);
        movieService.delete(id);
    }

    @GetMapping
    public List<Movie> search(@RequestParam(required = false) Genre genre,
                              @RequestParam(required = false) String title,
                              @RequestParam(required = false) LocalDate releasedBefore,
                              @RequestParam(required = false) LocalDate releasedAfter) {
        log.debug("search() called with genre = {}, title = {}, releasedBefore = {}, releasedAfter = {}",
                genre, title, releasedBefore, releasedAfter);
        return movieService.search(genre, title, releasedBefore, releasedAfter);
    }





}
