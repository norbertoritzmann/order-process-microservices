package order.application;

import common.Order;
import order.domain.PlaceOrderRequest;
import org.springframework.stereotype.Component;


@Component
public class OrderRequestToOrderPopulator implements OrderPopulator<PlaceOrderRequest, Order> {

	@Override
	public Order populate(final PlaceOrderRequest request) {
		return Order.createNewOrder(request.getCart(), request.getShipment());
	}
}
