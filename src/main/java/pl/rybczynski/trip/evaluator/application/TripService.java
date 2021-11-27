package pl.rybczynski.trip.evaluator.application;

import org.springframework.stereotype.Service;
import pl.rybczynski.trip.evaluator.model.Review;
import pl.rybczynski.trip.evaluator.model.Trip;
import pl.rybczynski.trip.evaluator.repository.TripRepo;

import java.util.List;

@Service
public class TripService {

    private final TripRepo tripRepo;

    public TripService(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    public Trip save(Trip trip) {
        return tripRepo.save(trip);
    }

    public void addReview(Long tripId, Review review) {
        Trip trip = findById(tripId);
        List<Review> reviews = trip.getReviews();
        reviews.add(review);
        trip.setReviews(reviews);
        tripRepo.save(trip);
    }

    public List<Trip> findAll() {
        return tripRepo.findAll();
    }

    public Trip findById(Long tripId) {
        return tripRepo.findById(tripId).orElseThrow();
    }

    public void delete(Long tripId) {
        tripRepo.deleteById(tripId);
    }
}
