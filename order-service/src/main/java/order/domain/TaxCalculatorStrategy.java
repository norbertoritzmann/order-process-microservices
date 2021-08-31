package order.domain;

import common.Entry;
import common.Product;

import java.math.BigDecimal;
import java.util.List;


public interface TaxCalculatorStrategy {
	BigDecimal calculate(Product product);

	void calculate(List<Entry> entries);
}
