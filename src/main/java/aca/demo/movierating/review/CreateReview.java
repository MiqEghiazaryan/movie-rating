package aca.demo.movierating.review;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;


@Value
@Builder
@Jacksonized

public class CreateReview {

    Long id;
    Long movieId;
    Long userId;
    String description;
    double rating;
    Instant createdAt;
}
