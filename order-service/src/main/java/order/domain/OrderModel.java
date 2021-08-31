package order.domain;

import common.OrderStatus;
import common.OrderType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
public class OrderModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
	private UUID id;

	@Column
	private OrderType type;

	@Column
	private LocalDateTime createdAt;

	@Column
	private OrderStatus status;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderEntryModel> entries;

	@Column
	private UUID shipment;

	@Column
	private BigDecimal totalBeforeTaxes;

	@Column
	private BigDecimal totalTaxes;

	@Column
	private BigDecimal total;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(final OrderStatus status) {
		this.status = status;
	}

	public List<OrderEntryModel> getEntries() {
		return entries;
	}

	public void setEntries(final List<OrderEntryModel> entries) {
		this.entries = entries;
	}

	public BigDecimal getTotalBeforeTaxes() {
		return totalBeforeTaxes;
	}

	public void setTotalBeforeTaxes(final BigDecimal totalBeforeTaxes) {
		this.totalBeforeTaxes = totalBeforeTaxes;
	}

	public BigDecimal getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(final BigDecimal totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public UUID getShipment() {
		return shipment;
	}

	public void setShipment(final UUID shipment) {
		this.shipment = shipment;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = total;
	}
}
