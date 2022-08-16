package FrugalFare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import frugalfarerestapi.FrugalFareRestApiApplication;
import frugalfarerestapi.dao.UserRepository;
import frugalfarerestapi.entity.User;

@Transactional
@Rollback
@SpringBootTest(classes = FrugalFareRestApiApplication.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	// checks if repository is autowired
	@Test
	void testUserRepositoryIsNotNull() {
		Assertions.assertNotNull(userRepository);
	}

	// checks if able to find user by ID;
	@Test
	void findUserById() {
		User user = userRepository.findById(1).get();
		Assertions.assertNotNull(user);
		Assertions.assertEquals("Shawn", user.getFirstName());
	}

	// checks to see if findall returns a non-null list;
	@Test
	void testIfFindAllIsNotNull() {
		Assertions.assertNotNull(userRepository.findAll());
	}

	// checks if a new user can be saved to the database;
	@Test
	void testSaveUser() {
		User user = new User();
		user.setFirstName("zzz");
		user.setLastName("zzz");
		user.setEmail("zzz@email.com");
		user.setPassword("zzzz");
		userRepository.save(user);
		User user2 = userRepository.findById(user.getId()).get();
		Assertions.assertEquals(user2, user);
	}

	// deletes a user and checks if they were delted.
	@Test
	void testDeleteUser() {
		userRepository.deleteById(1);
		Assertions.assertFalse(userRepository.findById(1).isPresent());
	}
}
