package frugalfarerestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ride")
public class Ride {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "start_address")
	private String startAddress;

	@Column(name = "end_address")
	private String endAddress;

	@Column(name = "lat1")
	private Double lat1;

	@Column(name = "long1")
	private Double long1;

	@Column(name = "lat2")
	private Double lat2;

	@Column(name = "long2")
	private Double long2;

	@Column(name = "miles")
	private Double miles;

	@Column(name = "uber_price")
	private Double uberPrice;

	@Column(name = "lyft_price")
	private Double lyftPrice;

	@Column(name = "taxi_price")
	private Double taxiPrice;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
