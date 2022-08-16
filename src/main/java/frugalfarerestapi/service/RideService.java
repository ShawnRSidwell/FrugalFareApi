package frugalfarerestapi.service;

import java.util.List;

import frugalfarerestapi.entity.Ride;

public interface RideService {

	public List<Ride> getRides();

	public void saveRide(Ride theRide);

	public Ride getRide(int rideId);

	public void deleteRide(int rideId);

}
