package common;

import java.io.Serializable;
import java.math.BigDecimal;


public class Entry implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;

	private Integer quantity;

	private BigDecimal shipmentCost;

	private BigDecimal totalBeforeTax;

	private BigDecimal totalTax;

	public Entry() {

	}

	public Entry(final Product product, final Integer quantity, final BigDecimal totalBeforeTax, final BigDecimal totalTax) {
		this.product = product;
		this.quantity = quantity;
		this.totalBeforeTax = totalBeforeTax;
		this.totalTax = totalTax;
	}

	public static Entry createEntry(final Product product, final Integer quantity, final BigDecimal totalBeforeTax,
		  final BigDecimal totalTax) {
		return new Entry(product, quantity, totalBeforeTax, totalTax);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalBeforeTax() {
		return totalBeforeTax;
	}

	public void setTotalBeforeTax(final BigDecimal totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(final BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getShipmentCost() {
		return shipmentCost;
	}

	public void setShipmentCost(BigDecimal shipmentCost) {
		this.shipmentCost = shipmentCost;
	}
}
