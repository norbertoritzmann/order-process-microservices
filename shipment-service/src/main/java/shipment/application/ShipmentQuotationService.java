package shipment.application;

import common.Address;
import common.Entry;
import common.Order;
import common.ShipmentQuotation;
import common.ShipmentQuotationRequest;
import org.springframework.stereotype.Component;
import shipment.domain.ShipmentQuotationCallerStrategy;

import java.math.BigDecimal;


@Component
public class ShipmentQuotationService {

	private ShipmentQuotationCallerStrategy quotationCaller;

	ShipmentQuotationService(ShipmentQuotationCallerStrategy quotationCaller) {

		this.quotationCaller = quotationCaller;
	}

	public void calculateShipmentFor(final Order order) {

		final Address address = order.getShipment().getDeliveryAddress();

		BigDecimal total = BigDecimal.ZERO;
		for (Entry entry : order.getEntries()) {
			ShipmentQuotationRequest request = new ShipmentQuotationRequest(entry.getProduct(), address);
			ShipmentQuotation shipmentQuotation = this.quotationCaller.callShipmentQuotationService(request);
			entry.setShipmentCost(shipmentQuotation.getQuotation());
			total = total.add(shipmentQuotation.getQuotation());
		}

		order.getShipment().setPrice(total);
	}

}
