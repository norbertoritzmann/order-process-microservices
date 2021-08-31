package shipment.infrastructure;

import common.Address;
import common.ShipmentQuotation;
import common.ShipmentQuotationRequest;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import shipment.domain.ShipmentQuotationCallerStrategy;

import java.math.BigDecimal;


@Component
public class DhlShipmentQuotationCaller implements ShipmentQuotationCallerStrategy {
	private static final String SHIPMENT = "shipment";
	protected static final Logger LOGGER = LoggerFactory.getLogger(DhlShipmentQuotationCaller.class);

	@CircuitBreaker(name = SHIPMENT, fallbackMethod = "fallback")
	@Bulkhead(name = SHIPMENT)
	@Retry(name = SHIPMENT, fallbackMethod = "fallback")
	public ShipmentQuotation callShipmentQuotationService(ShipmentQuotationRequest request) {

		WebClient client = WebClient.create("http://localhost:3224");
		WebClient.UriSpec<WebClient.RequestBodySpec> requestBodyUriSpec = client.method(HttpMethod.GET);
		WebClient.RequestBodySpec bodySpec = requestBodyUriSpec.uri("/dhl/api/shipment/quotation");

		WebClient.RequestHeadersSpec<?> headersSpec = bodySpec.body(Mono.just(request.getAddress()), Address.class);

		return new ShipmentQuotation(headersSpec.retrieve().bodyToMono(BigDecimal.class).block());
	}

	private ShipmentQuotation fallback(final ShipmentQuotationRequest param, final IllegalArgumentException e) {
		LOGGER.error("An error ocurried and captured by the fallback", e);
		return new ShipmentQuotation(BigDecimal.ZERO);
	}

	private ShipmentQuotation fallback(final ShipmentQuotationRequest param, final Throwable e) {
		LOGGER.error("An error ocurried and captured by the fallback", e);
		return new ShipmentQuotation(BigDecimal.ZERO);
	}
}
