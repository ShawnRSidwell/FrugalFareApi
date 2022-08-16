package FrugalFare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import frugalfarerestapi.FrugalFareRestApiApplication;
import frugalfarerestapi.dao.RideRepository;
import frugalfarerestapi.entity.Ride;

@Transactional
@Rollback
@SpringBootTest(classes = FrugalFareRestApiApplication.class)
public class RideRepositoryTest {

	@Autowired
	RideRepository rideRepository;

	// checks if repository is autowired
	@Test
	void testRideRepositoryIsNotNull() {
		Assertions.assertNotNull(rideRepository);
	}

	// checks if able to find ride by ID;
	@Test
	void findRideById() {
		Ride ride = new Ride();
		ride.setStartAddress("123 Main Street");
		rideRepository.save(ride);
		Ride ride2 = rideRepository.findById(ride.getId()).get();
		Assertions.assertNotNull(ride2);
		Assertions.assertEquals("123 Main Street", ride2.getStartAddress());
	}

	// checks to see if findall returns a non-null list;
	@Test
	void testIfFindAllIsNotNull() {
		Assertions.assertNotNull(rideRepository.findAll());
	}

	// checks if a new ride can be saved to the database;
	@Test
	void testSaveRide() {
		Ride ride = new Ride();
		rideRepository.save(ride);
		Ride ride2 = rideRepository.findById(ride.getId()).get();
		Assertions.assertEquals(ride, ride2);
	}

	// deletes a ride and checks if they were deleted.
	@Test
	void testDeleteRide() {
		Ride ride = new Ride();
		rideRepository.save(ride);
		int rideId = ride.getId();
		rideRepository.deleteById(rideId);
		Assertions.assertFalse(rideRepository.findById(rideId).isPresent());
	}
}
