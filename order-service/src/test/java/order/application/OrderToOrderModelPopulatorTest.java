package order.application;

import common.Entry;
import common.Order;
import common.Product;
import common.Shipment;
import common.ShipmentType;
import order.domain.IllegalOrderStateException;
import order.domain.OrderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class OrderToOrderModelPopulatorTest {

	private static final BigDecimal TAX = BigDecimal.valueOf(0.19);
	private static final BigDecimal T_SHIRT_PRICE = BigDecimal.valueOf(10.0);
	private static final BigDecimal T_SHIRT_TAX = T_SHIRT_PRICE.multiply(TAX);
	private static final BigDecimal T_SHIRT_TOTAL = T_SHIRT_PRICE.add(T_SHIRT_TAX);

	private final OrderToOrderModelPopulator populator = new OrderToOrderModelPopulator();
	Product tShirt = new Product(UUID.randomUUID(), "T-Shirt", BigDecimal.valueOf(10.0));
	List<Entry> entries = Collections
		  .singletonList(Entry.createEntry(tShirt, 1, tShirt.getPrice(), tShirt.getPrice().multiply(TAX)));

	@Test
	void populate_givenOrder() {
		final Order tShirtOrder = Order.createNewOrder(entries, Shipment.create(ShipmentType.NORMAL, BigDecimal.valueOf(0.0)));

		final OrderModel model = populator.populate(tShirtOrder);

		assertThat(model.getId()).isNotNull();
		assertThat(model.getEntries()).isNotEmpty();
		assertThat(model.getShipment()).isEqualTo(tShirtOrder.getShipment().getId());
		assertThat(model.getTotalTaxes()).isEqualByComparingTo(T_SHIRT_TAX);
		assertThat(model.getTotalBeforeTaxes()).isEqualByComparingTo(T_SHIRT_PRICE);
		assertThat(model.getTotal()).isEqualByComparingTo(T_SHIRT_TOTAL);
		assertThat(model.getStatus()).isEqualByComparingTo(tShirtOrder.getStatus());
		assertThat(model.getCreatedAt()).isEqualTo(tShirtOrder.getCreatedAt());
	}

	@Test
	void populate_givenNoShipment() {
		final Order tShirtOrder = Order.createNewOrder(entries, null);

		Assertions.assertThrows(IllegalOrderStateException.class, () -> populator.populate(tShirtOrder));
	}


}
