package aca.demo.movierating.review;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Slf4j
public class ReviewRepository {
    private final List<Review> reviews = new ArrayList<>();
    public Optional<Review> findById(Long movieId, Long id) {
        log.debug("Finding review by - movieId: {}, and reviewId: {}", movieId, id);
        return reviews.stream().filter(r -> r.getMovieId().equals(movieId) && r.getId().equals(id)).findFirst();
    }
    public List<Review> search(String description, Instant updatedBefore, Instant updatedAfter, Long userId,double ratingHigherThan,double ratingLowerThan) {
        log.debug("find review by description - {},updatedBefore - {},updatedAfter,userId - {},ratingHigherThan -{},ratingLowerThan-{}",
                description,updatedBefore,updatedAfter,userId,ratingHigherThan,ratingLowerThan);
        return reviews.stream()
                .filter(review -> description == null || review.getDescription().equals(description))
                .filter(review -> updatedBefore == null || review.getUpdatedAt().isBefore(updatedBefore))
                .filter(review -> updatedAfter == null || review.getUpdatedAt().isAfter(updatedAfter))
                .filter(review -> userId == null || review.getUserId().equals(userId))
                .filter(review -> ratingHigherThan == 0.0 || Double.compare(review.getRating(), ratingHigherThan) == 1)
                .filter(review -> ratingLowerThan == 0.0 || Double.compare(review.getRating(), ratingLowerThan) == -1)
                .toList();
    }
    public void persist(Review review) {
        log.debug("Adding new review to reviews list - {}", review);
        reviews.add(review);
    }
    public void delete(Long movieId, Review review) {
        log.debug("Deleting review - {}", review);
        reviews.remove(findById(movieId, review.getId()).get());
    }
}
