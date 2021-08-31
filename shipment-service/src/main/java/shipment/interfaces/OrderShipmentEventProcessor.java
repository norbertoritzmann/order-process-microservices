package shipment.interfaces;

import common.Order;
import common.ShipmentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import shipment.application.ShipmentQuotationService;

import java.util.function.Function;


@Component
public class OrderShipmentEventProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderShipmentEventProcessor.class.getName());

	private final ShipmentQuotationService shipmentQuotation;


	public OrderShipmentEventProcessor(final ShipmentQuotationService shipmentQuotation) {
		this.shipmentQuotation = shipmentQuotation;
	}

	@Bean
	public Function<Order, Order> processShipment() {

		return order -> {
			LOGGER.info("[{}] Processing shipment for the order", order.getId());

			shipmentQuotation.calculateShipmentFor(order);

			LOGGER.info("[{}] DHL Quotation for the whole order: {}", order.getId(), order.getShipment().getPrice());

			order.getShipment().setStatus(ShipmentStatus.IN_PROCESS);

			return order;
		};
	}

}
