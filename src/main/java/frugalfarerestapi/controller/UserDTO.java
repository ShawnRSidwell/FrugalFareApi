package frugalfarerestapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import frugalfarerestapi.entity.Ride;
import frugalfarerestapi.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private List<RideDTO> rides;

	//Create a data transfer object for a user. Do not include their password.
	public UserDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.rides = new ArrayList<RideDTO>();
		for (Ride ride : user.getRides()) {
			this.rides.add(new RideDTO(ride));

		}
	}

}
