package aca.demo.movierating.endpoint;


import aca.demo.movierating.review.CreateReview;
import aca.demo.movierating.review.Review;
import aca.demo.movierating.review.ReviewService;
import aca.demo.movierating.review.UpdateReview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reviews")

public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Review> getById(@PathVariable Long movieId,Long userId) {
        log.debug("getById() called with movieId = {},userId = {}", movieId,userId);
        Review review = reviewService.getById(movieId,userId);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Long movieId, CreateReview createReview) {
        log.debug("Creating with -{}",createReview);
        reviewService.create(movieId,createReview);

    }

    @PutMapping("/{id}")
    public void  update(@PathVariable Long movieId,@PathVariable Long id, @RequestBody UpdateReview updateReview) {
        log.debug("update() called with movieId = {}, id = {} and updateReview = {}",movieId, id, updateReview);
        reviewService.update(movieId,id, updateReview);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,Long movieId) {
        log.debug("delete() called with id = {},movieId = {}",id,movieId);
        reviewService.delete(id,movieId);
    }

    @GetMapping
    public List<Review> search(@RequestParam(required = false) String description,
                              @RequestParam(required = false) Instant updatedBefore,
                              @RequestParam(required = false) Instant updatedAfter,
                              @RequestParam(required = false) Long userId,
                              @RequestParam(required = false) double ratingHigherThan,
                              @RequestParam(required = false) double ratingLowerThan) {
        log.debug("search() called with description = {}, updatedBefore = {}, updatedAfter = {}, userId = {},ratingHigherThan = {},ratingLowerThan = {}",
                description,updatedBefore,updatedAfter,userId,ratingHigherThan,ratingLowerThan);

        return reviewService.search(description, updatedBefore, updatedAfter, userId, ratingHigherThan, ratingLowerThan);
    }
}
