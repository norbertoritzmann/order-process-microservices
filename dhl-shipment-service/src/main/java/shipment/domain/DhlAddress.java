package shipment.domain;

import java.io.Serializable;
import java.util.UUID;


public class DhlAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String street;
	private String number;
	private String country;
	private String region;

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}

	public String getFullAddress() {
		return String.format("%s, %s - %s - %s", this.getStreet(), this.getNumber(), this.getRegion(), this.getCountry());
	}
}
