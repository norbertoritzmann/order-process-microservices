package order.application;

import common.Order;
import order.domain.IllegalOrderStateException;
import order.domain.OrderEntryModel;
import order.domain.OrderModel;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.stream.Collectors;


@Component
public class OrderToOrderModelPopulator {

	public OrderModel populate(final Order order) {
		final OrderModel model = new OrderModel();

		if (order.getId() != null) {
			model.setId(order.getId());
		}

		if (CollectionUtils.isEmpty(order.getEntries())) {
			throw new IllegalOrderStateException("There are no order without entries.");
		}

		if (order.getShipment() == null) {
			throw new IllegalOrderStateException(
				  "No shipment found, in order to deliver a product you should specify a shipment");
		}

		model.setCreatedAt(order.getCreatedAt());

		model.setEntries(order.getEntries().stream().map(entry -> OrderEntryModel.fromEntryAndOrderModel(entry, model))
			  .collect(Collectors.toList()));

		model.setTotalTaxes(
			  model.getEntries().stream().map(OrderEntryModel::getTax).reduce(BigDecimal::add).orElse(BigDecimal.valueOf(0.0)));

		model.setTotalBeforeTaxes(model.getEntries().stream().map(OrderEntryModel::getPriceBeforeTax).reduce(BigDecimal::add)
			  .orElse(BigDecimal.valueOf(0.0)));

		model.setTotal(model.getTotalBeforeTaxes().add(model.getTotalTaxes()));

		model.setShipment(order.getShipment().getId());
		model.setStatus(order.getStatus());

		return model;
	}
}
