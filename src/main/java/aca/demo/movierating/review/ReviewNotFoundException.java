package aca.demo.movierating.review;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(String message){
        super(message);
    }
}
