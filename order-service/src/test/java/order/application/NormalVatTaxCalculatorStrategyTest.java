package order.application;

import common.Entry;
import common.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;


class NormalVatTaxCalculatorStrategyTest {

	private final NormalVatTaxCalculatorStrategy taxCalculator = new NormalVatTaxCalculatorStrategy();

	@Test
	void calculateGivenProduct() {
		final Product product = new Product(UUID.randomUUID(), "T-Shirt", BigDecimal.TEN);

		final BigDecimal tax = taxCalculator.calculate(product);

		final BigDecimal productTax = NormalVatTaxCalculatorStrategy.TAX.multiply(product.getPrice());
		Assertions.assertThat(tax).isEqualTo(productTax);
	}

	@Test
	void calculateGivenEntries() {

		final Product product = new Product(UUID.randomUUID(), "T-Shirt", BigDecimal.TEN);
		final Entry entry = new Entry(product, 3, BigDecimal.TEN.multiply(BigDecimal.valueOf(3.0)), null);

		taxCalculator.calculate(Collections.singletonList(entry));

		final BigDecimal entryTaxShouldBe = NormalVatTaxCalculatorStrategy.TAX.multiply(product.getPrice())
			  .multiply(BigDecimal.valueOf(3.0));
		Assertions.assertThat(entry.getTotalTax()).isEqualTo(entryTaxShouldBe);
	}
}
