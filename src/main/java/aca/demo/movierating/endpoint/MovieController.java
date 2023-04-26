package aca.demo.movierating.endpoint;


import aca.demo.movierating.movie.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
@Slf4j
@RequiredArgsConstructor

public class MovieController {
    private final MovieService movieService;


    @PostMapping("movies")
    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    @GetMapping("movies")
    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException {



    }
}
