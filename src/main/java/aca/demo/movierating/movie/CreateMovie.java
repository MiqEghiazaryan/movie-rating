package aca.demo.movierating.movie;

import lombok.Value;


@Value

public final class CreateMovie {
    String title;
    Genre genre;
}
