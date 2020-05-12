package io.santosh.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.santosh.model.Rating;
import io.santosh.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataResource {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings=Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
		UserRating userRating=new UserRating();
		userRating.setRatings(ratings);
		
		return userRating;
	}
}
