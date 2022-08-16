package frugalfarerestapi.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import frugalfarerestapi.entity.Ride;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RideDTO {

	private int id;

	private String startAddress;

	private String endAddress;

	private Double lat1;

	private Double long1;

	private Double lat2;

	private Double long2;

	private Double miles;

	private Double uberPrice;

	private Double lyftPrice;

	private Double taxiPrice;

	private String userName;

	public RideDTO(Ride ride) {
		this.id = ride.getId();
		this.startAddress = ride.getStartAddress();
		this.endAddress = ride.getEndAddress();
		this.lat1 = ride.getLat1();
		this.long1 = ride.getLong1();
		this.lat2 = ride.getLat2();
		this.long2 = ride.getLong2();
		this.miles = ride.getMiles();
		this.uberPrice = ride.getUberPrice();
		this.lyftPrice = ride.getLyftPrice();
		this.taxiPrice = ride.getTaxiPrice();
		this.userName = ride.getUser().getFirstName() + " " + ride.getUser().getLastName();
	}

}
