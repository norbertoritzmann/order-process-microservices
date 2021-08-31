package order.application;

import common.Order;
import common.OrderStatus;
import order.domain.IllegalOrderStateException;
import order.domain.OrderModel;
import order.domain.PlaceOrderRequest;
import order.domain.TaxCalculatorStrategy;
import order.domain.repository.OrderRepository;
import order.infrastructure.OrderProcessStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaceOrderService {
	private final OrderRepository orderRepository;
	private final OrderPopulator<PlaceOrderRequest, Order> orderRequestPopulator;
	private final OrderToOrderModelPopulator orderToModel;
	private final OrderProcessStarter processor;
	private final TaxCalculatorStrategy taxCalculator;

	@Autowired
	public PlaceOrderService(final OrderRepository orderRepository,
		  final OrderPopulator<PlaceOrderRequest, Order> orderRequestPopulator, final OrderToOrderModelPopulator orderToModel,
		  final OrderProcessStarter processor, final TaxCalculatorStrategy taxCalculator) {
		this.orderRepository = orderRepository;
		this.orderRequestPopulator = orderRequestPopulator;
		this.orderToModel = orderToModel;
		this.processor = processor;
		this.taxCalculator = taxCalculator;
	}

	public Order placeOrder(final PlaceOrderRequest request) throws IllegalOrderStateException {
		final Order order = orderRequestPopulator.populate(request);

		order.setStatus(OrderStatus.PROCESSING);

		taxCalculator.calculate(order.getEntries());

		final OrderModel savedOrder = orderRepository.save(orderToModel.populate(order));
		order.setId(savedOrder.getId());

		processor.startProcess(order);

		return order;
	}

}
