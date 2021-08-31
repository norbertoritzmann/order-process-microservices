package order.domain;

import common.Entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;


@Entity
public class OrderEntryModel {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long entryId;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderModel order;

	@Column
	private UUID productReference;

	@Column
	private Integer quantity;

	@Column
	private BigDecimal priceBeforeTax;

	@Column
	private BigDecimal tax;

	public OrderEntryModel() {

	}

	public OrderEntryModel(final OrderModel order, final UUID productReference, final BigDecimal priceBeforeTax,
		  final BigDecimal tax) {
		this.order = order;
		this.productReference = productReference;
		this.priceBeforeTax = priceBeforeTax;
		this.tax = tax;
	}

	public static OrderEntryModel fromEntryAndOrderModel(final Entry entry, final OrderModel order) {
		return new OrderEntryModel(order, entry.getProduct().getId(), entry.getTotalBeforeTax(), entry.getTotalTax());
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(final OrderModel order) {
		this.order = order;
	}

	public UUID getProductReference() {
		return productReference;
	}

	public void setProductReference(final UUID productReference) {
		this.productReference = productReference;
	}

	public BigDecimal getPriceBeforeTax() {
		return priceBeforeTax;
	}

	public void setPriceBeforeTax(final BigDecimal priceBeforeTax) {
		this.priceBeforeTax = priceBeforeTax;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(final BigDecimal tax) {
		this.tax = tax;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}
}
