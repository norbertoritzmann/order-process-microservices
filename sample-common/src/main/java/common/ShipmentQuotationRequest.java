package common;

import java.io.Serializable;


public class ShipmentQuotationRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product product;

	private Address address;

	public ShipmentQuotationRequest() {

	}

	public ShipmentQuotationRequest(final Product product, final Address address) {
		this.product = product;
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}
}
