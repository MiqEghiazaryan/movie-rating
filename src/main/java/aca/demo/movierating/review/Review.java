package aca.demo.movierating.review;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;


@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Slf4j
@AllArgsConstructor

public class Review {

    @EqualsAndHashCode.Include
    Long id;
    Long movieId;
    Long userId;
    String description;
    double rating;
    Instant createdAt;
    Instant updatedAt;


    public Review(CreateReview createReview) {
        log.debug("CreateReview constructor - {}",createReview);
    }

    void update(UpdateReview updateReview){
        log.debug("Updating review with updatReview - {}",updateReview);

        this.id = updateReview.getId();
        this.userId = updateReview.getUserId();
        this.movieId = updateReview.getMovieId();
        this.description = updateReview.getDescription();
        this.rating = updateReview.getRating();

    }

}
