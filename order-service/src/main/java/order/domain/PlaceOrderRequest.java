package order.domain;

import common.Cart;
import common.Shipment;

import java.io.Serializable;


public class PlaceOrderRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private Cart cart;
	private Shipment shipment;

	public Cart getCart() {
		return cart;
	}

	public void setCart(final Cart cart) {
		this.cart = cart;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(final Shipment shipment) {
		this.shipment = shipment;
	}
}
