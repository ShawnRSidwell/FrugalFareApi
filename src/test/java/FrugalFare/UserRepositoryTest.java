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

	//Checks if repository is autowired
	@Test
	void testUserRepositoryIsNotNull() {
		Assertions.assertNotNull(userRepository);
	}

	//Checks if able to find user by ID;
	@Test
	void findUserById() {
		User user = userRepository.findById(35).get();
		Assertions.assertNotNull(user);
		Assertions.assertEquals("Fred", user.getFirstName());
	}

	//Checks to see if findall returns a non-null list;
	@Test
	void testIfFindAllIsNotNull() {
		Assertions.assertNotNull(userRepository.findAll());
	}

	//Checks if a new user can be saved to the database;
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

	//Deletes a user and checks if they were delted.
	@Test
	void testDeleteUser() {
		userRepository.deleteById(27);
		Assertions.assertFalse(userRepository.findById(27).isPresent());
	}
}
