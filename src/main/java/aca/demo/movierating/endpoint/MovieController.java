package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor

public class MovieController {
    private final MovieService movieService;
}
