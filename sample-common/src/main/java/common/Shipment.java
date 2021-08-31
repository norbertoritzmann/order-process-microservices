package common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class Shipment implements Serializable {

	private static final long serialVersionUID = 1L;
	private UUID id;
	private ShipmentType type;
	private LocalDate date;
	private BigDecimal price;
	private ShipmentStatus status;

	private Address deliveryAddress;

	public Shipment() {

	}

	private Shipment(final UUID id, final ShipmentType type, final LocalDate date, final BigDecimal price) {
		this.id = id;
		this.type = type;
		this.date = date;
		this.price = price;
		this.status = ShipmentStatus.NEW;
	}

	private Shipment(final UUID id, final ShipmentType type, final LocalDate date, final BigDecimal price,
		  final ShipmentStatus status) {
		this.id = id;
		this.type = type;
		this.date = date;
		this.price = price;
		this.status = status;
	}

	public static Shipment create(final UUID id, final ShipmentType type, final LocalDate date, final BigDecimal price,
		  final ShipmentStatus status) {
		return new Shipment(id, type, date, price, status);
	}

	public static Shipment create(final ShipmentType type, final BigDecimal price) {
		return new Shipment(null, type, null, price);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ShipmentType getType() {
		return type;
	}

	public void setType(final ShipmentType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(final LocalDate date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(final Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(final ShipmentStatus status) {
		this.status = status;
	}
}
