package order.application;

import common.Entry;
import common.Product;
import order.domain.TaxCalculatorStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
public class NormalVatTaxCalculatorStrategy implements TaxCalculatorStrategy {

	static final BigDecimal TAX = BigDecimal.valueOf(0.19);

	@Override
	public BigDecimal calculate(final Product product) {
		return product.getPrice().multiply(TAX);
	}

	@Override
	public void calculate(final List<Entry> entries) {

		entries.forEach(entry -> entry.setTotalTax(entry.getTotalBeforeTax().multiply(TAX)));
	}
}
