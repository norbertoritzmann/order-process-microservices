package order.interfaces;

import common.Order;
import order.application.PlaceOrderService;
import order.domain.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private final PlaceOrderService placeOrderService;

	@Autowired
	public OrderController(final PlaceOrderService placeOrderService) {
		this.placeOrderService = placeOrderService;
	}

	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody final PlaceOrderRequest request) {

		return new ResponseEntity<>(placeOrderService.placeOrder(request), HttpStatus.CREATED);
	}
}
