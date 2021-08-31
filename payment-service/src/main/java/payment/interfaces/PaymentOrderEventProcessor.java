package payment.interfaces;

import common.Order;
import common.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class PaymentOrderEventProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentOrderEventProcessor.class.getName());

	@Bean
	public Function<Order, Order> processPayment() {

		return order -> {
			LOGGER.info("[{}] Processing payment", order.getId());
			order.setStatus(OrderStatus.PAYMENT_AUTHORIZED);

			LOGGER.info("[{}] Payment Authorized", order.getId());

			return order;
		};
	}
}
