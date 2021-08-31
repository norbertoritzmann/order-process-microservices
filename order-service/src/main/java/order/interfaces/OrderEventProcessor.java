package order.interfaces;

import common.Order;
import common.OrderStatus;
import order.domain.MessagingProcessor;
import order.domain.OrderModel;
import order.domain.repository.OrderRepository;
import order.infrastructure.EventDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;


@Component
public class OrderEventProcessor implements MessagingProcessor<Order> {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventProcessor.class.getName());
	private final OrderRepository orderRepository;

	public OrderEventProcessor(final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Bean
	Consumer<Order> receiveSuccessfulProcessEndInput() {
		return this::markAsCompleteAndReadyToDeliver;
	}

	void markAsCompleteAndReadyToDeliver(final Order order) {
		LOGGER.info("[{}] Receiving back the ORDER with the status {}", order.getId(), order.getStatus());
		final Optional<OrderModel> optionalModel = this.orderRepository.findById(order.getId());

		if (optionalModel.isEmpty()) {
			LOGGER.error("The orderId is not valid and could not finish the order process.");
		}
		else {
			final OrderModel model = optionalModel.get();
			model.setStatus(OrderStatus.READY_TO_DELIVER);
			LOGGER.info("Order Ready to deliver");
			this.orderRepository.save(model);
		}
	}
}
