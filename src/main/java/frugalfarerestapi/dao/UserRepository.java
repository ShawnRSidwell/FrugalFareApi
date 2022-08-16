package frugalfarerestapi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import frugalfarerestapi.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findAll();

	public User findUserById(int theId);

}
