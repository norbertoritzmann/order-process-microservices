package common;

import java.io.Serializable;
import java.math.BigDecimal;


public class ShipmentQuotation implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal quotation;

	public ShipmentQuotation() {

	}

	public ShipmentQuotation(final BigDecimal quotation) {
		this.quotation = quotation;
	}

	public static ShipmentQuotation forQuotationValue(final Double quotation) {

		return new ShipmentQuotation(BigDecimal.valueOf(quotation));
	}

	public BigDecimal getQuotation() {
		return quotation;
	}

	public void setQuotation(final BigDecimal quotation) {
		this.quotation = quotation;
	}
}
