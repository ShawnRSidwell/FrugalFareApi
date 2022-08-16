package frugalfarerestapi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import frugalfarerestapi.entity.Ride;

public interface RideRepository extends CrudRepository<Ride, Integer> {

	public List<Ride> findAll();

	public Ride findRideById(int rideId);

	public void deleteRideById(int rideId);

}
