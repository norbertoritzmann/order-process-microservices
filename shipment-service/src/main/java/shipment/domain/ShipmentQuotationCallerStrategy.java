package shipment.domain;

import common.ShipmentQuotation;
import common.ShipmentQuotationRequest;


public interface ShipmentQuotationCallerStrategy {

	ShipmentQuotation callShipmentQuotationService(ShipmentQuotationRequest request);

}
