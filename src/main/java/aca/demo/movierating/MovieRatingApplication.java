package aca.demo.movierating;

import aca.demo.movierating.movie.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class MovieRatingApplication {

	public static void main(String[] args) {
		var applicationContext	= SpringApplication.run(MovieRatingApplication.class, args);
		applicationContext.getBean(MovieService.class);


	}

}
