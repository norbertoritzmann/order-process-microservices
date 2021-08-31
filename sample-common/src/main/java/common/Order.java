package common;

import common.exception.IllegalOrderStateException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID id;
	private OrderType type;
	private LocalDateTime createdAt;
	private OrderStatus status;
	private List<Entry> entries;
	private Shipment shipment;

	public Order(final UUID id, final OrderType type, final LocalDateTime createdAt, final OrderStatus status,
		  final List<Entry> entries, final Shipment shipment) {
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
		this.status = status;
		this.setEntries(entries);
		this.shipment = shipment;
	}

	public Order() {

	}

	public static Order createNewOrder(final OrderType type, final List<Entry> entries, final Shipment shipment) {
		return new Order(UUID.randomUUID(), type, LocalDateTime.now(), OrderStatus.NEW, entries, shipment);
	}

	public static Order createNewOrder(final List<Entry> entries, final Shipment shipment) {
		return createNewOrder(OrderType.PURCHASE, entries, shipment);
	}

	public static Order createNewOrder(final Cart cart, final Shipment shipment) {
		return createNewOrder(cart.getEntries(), shipment);
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(final OrderType type) {
		this.type = type;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(final OrderStatus status) {
		this.status = status;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(final Shipment shipment) {
		this.shipment = shipment;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(final List<Entry> entries) {
		if (entries.isEmpty()) {
			throw new IllegalOrderStateException("At least one product should be informed");
		}

		this.entries = entries;
	}

	@Override
	public String toString() {
		return String.format("Order[id=%s,entries=%s,shipment=%s]", id,
			  entries.stream().map(entry -> entry.getProduct().toString()).collect(Collectors.joining(", ")), shipment.getId());
	}

}
