package aca.demo.movierating;

import aca.demo.movierating.movie.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MovieRatingApplication {

	public static void main(String[] args) {
		var applicationContext	= SpringApplication.run(MovieRatingApplication.class, args);

		var movieService = applicationContext.getBean(MovieService.class);

	    movieService.create(new CreateMovie("Forrest Gump", Genre.DRAMA));
		movieService.create(new CreateMovie("Horrible Bosses", Genre.COMEDY));
		movieService.create(new CreateMovie("American Beauty", Genre.DRAMA));


		List<Movie> dramaMovies = movieService.search(Genre.DRAMA);
		log.debug("Found drama movies: {}", dramaMovies);

		List<Movie> romanceMovies = movieService.search(Genre.ROMANCE);
		log.debug("Find romance movies: {}",romanceMovies);


	}

}
