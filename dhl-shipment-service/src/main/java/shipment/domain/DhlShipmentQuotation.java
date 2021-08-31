package shipment.domain;

import java.io.Serializable;
import java.math.BigDecimal;


public class DhlShipmentQuotation implements Serializable {
	private BigDecimal quotation;

	public DhlShipmentQuotation(BigDecimal quotation) {
		this.quotation = quotation;
	}

	public BigDecimal getQuotation() {
		return quotation;
	}

	public void setQuotation(BigDecimal quotation) {
		this.quotation = quotation;
	}
}
