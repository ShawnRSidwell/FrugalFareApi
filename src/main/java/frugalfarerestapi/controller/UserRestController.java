package frugalfarerestapi.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frugalfarerestapi.entity.User;
import frugalfarerestapi.service.UserService;



@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	private List<User> theUsers;

	private User theUser;

	//Define user endpoint and provides a list of users.
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		
		theUsers = userService.findAll();
		
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : theUsers) {
			usersDTO.add(new UserDTO(user));
		}
		return usersDTO;
	}

	// Define endpoint and returns user with given Id
	@GetMapping("/users/{userId}")
	public UserDTO getUser(@PathVariable int userId) {

		theUser = userService.findUserById(userId);
		UserDTO userDTO = new UserDTO(theUser);
		return userDTO;

	}

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {

		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc) {

		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
