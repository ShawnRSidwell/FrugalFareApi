package frugalfarerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import frugalfarerestapi.dao.RideRepository;
import frugalfarerestapi.entity.Ride;

@Service
public class RideServiceImpl implements RideService {

	private RideRepository rideRepository;

	@Autowired
	public RideServiceImpl(RideRepository theRideRepository) {
		rideRepository = theRideRepository;
	}

	@Override
	@Transactional
	public List<Ride> getRides() {

		return rideRepository.findAll();
	}

	@Override
	@Transactional
	public void saveRide(Ride theRide) {

		rideRepository.save(theRide);
	}

	@Override
	@Transactional
	public Ride getRide(int rideId) {

		return rideRepository.findRideById(rideId);
	}

	@Override
	@Transactional
	public void deleteRide(int rideId) {

		rideRepository.deleteRideById(rideId);

	}

}
