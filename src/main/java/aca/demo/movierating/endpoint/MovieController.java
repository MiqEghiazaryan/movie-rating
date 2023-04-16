package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.CreateMovie;
import aca.demo.movierating.movie.Genre;
import aca.demo.movierating.movie.Movie;
import aca.demo.movierating.movie.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor

public class MovieController {
    private final MovieService movieService;


    @PostMapping("movies")
    public void create(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String title = request.getParameter("title");
        String genreString = request.getParameter("genre");
        Genre genre = Genre.valueOf(genreString);

        log.info("Received request to create movie with title {} and genre {}", title, genre);

        try {
            movieService.create(new CreateMovie(title, genre));
            response.setStatus(202);
            response.setContentType("text/plain");
            response.getWriter().println("New Movie created!");
        } catch (IllegalArgumentException e) {
            log.error("Error creating movie: {}", e.getMessage());
            response.setStatus(400);
            response.setContentType("text/plain");
            response.getWriter().println(e.getMessage());
        }

    }
    @GetMapping("movies")
    public void search(HttpServletRequest request, HttpServletResponse response) {

        String genreParam = request.getParameter("genre");
        Genre genre = Genre.valueOf(genreParam.toUpperCase());

        List<Movie> movies = movieService.search(genre);

        StringBuilder responseBody = new StringBuilder("Movies with genre " + genre + ":\n");
        for (Movie movie : movies) {
            responseBody.append("Title: ").append(movie.getTitle()).append(", Genre: ").append(movie.getGenre()).append("\n");
        }

        try {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/plain");
            response.getWriter().println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
