package order.infrastructure;

import common.Order;
import order.domain.MessagingProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class OrderProcessStarter implements MessagingProcessor<Order> {
	static final String ORDER_STREAM_OUT = "orderPayment-out-0";
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessStarter.class.getName());
	private final EventDispatcher eventDispatcher;

	public OrderProcessStarter(final EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public void startProcess(final Order order) {
		final boolean sent = eventDispatcher.dispatch(ORDER_STREAM_OUT, message(order));
		LOGGER.info("[{}] Order process started? {}", order.getId(), sent);
	}

}
