package shipment.application;


import shipment.domain.DhlAddress;
import shipment.domain.DhlShipmentQuotation;


public interface ShipmentQuotationCalculatorStrategy {
	DhlShipmentQuotation quotationFor(final DhlAddress address);
}
