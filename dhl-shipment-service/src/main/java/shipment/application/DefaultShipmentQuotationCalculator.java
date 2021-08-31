package shipment.application;

import org.springframework.stereotype.Service;
import shipment.domain.DhlAddress;
import shipment.domain.DhlShipmentQuotation;

import java.math.BigDecimal;


@Service
public class DefaultShipmentQuotationCalculator implements ShipmentQuotationCalculatorStrategy {


	public DhlShipmentQuotation quotationFor(final DhlAddress address) {


		return new DhlShipmentQuotation(BigDecimal.valueOf(2.0));
	}

}
