package common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


public class Product implements Serializable {

	private static final long serialVersionUID = 7119622238647153337L;
	private UUID id;
	private String name;
	private BigDecimal price;

	public Product() {

	}

	public Product(final String name, final BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public Product(final String name) {
		super();
		this.name = name;
	}

	public Product(final UUID id, final String name, final BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

}
