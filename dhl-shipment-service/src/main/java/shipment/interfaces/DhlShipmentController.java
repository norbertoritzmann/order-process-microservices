package shipment.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shipment.application.DefaultShipmentQuotationCalculator;
import shipment.domain.DhlAddress;
import shipment.domain.DhlShipmentQuotation;

import java.math.BigDecimal;


@RestController
@RequestMapping("/dhl/api/shipment")
public class DhlShipmentController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DefaultShipmentQuotationCalculator defaultShipmentQuotationCalculator;

	@GetMapping(path = "/quotation")
	public ResponseEntity<BigDecimal> calculateShipmentFor(@RequestBody final DhlAddress quotationRequest) {
		logger.info("[DHL] Processing a quotation request to {}", quotationRequest.getFullAddress());

		return new ResponseEntity<>(defaultShipmentQuotationCalculator.quotationFor(quotationRequest).getQuotation(), HttpStatus.OK);
	}

}
