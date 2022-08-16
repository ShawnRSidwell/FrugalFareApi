package frugalfarerestapi.service;

import java.util.List;

import frugalfarerestapi.entity.User;

public interface UserService {
	public List<User> findAll();

	public void saveUser(User theUser);

	public User findUserById(int theId);

	public void deleteUser(int theId);
}
