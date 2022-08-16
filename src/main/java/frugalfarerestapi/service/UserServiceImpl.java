package frugalfarerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import frugalfarerestapi.dao.UserRepository;
import frugalfarerestapi.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	@Transactional
	public User findUserById(int theId) {
		return userRepository.findUserById(theId);
	}

	@Transactional
	public void deleteUser(int theId) {

		userRepository.deleteById(theId);
	}

}
