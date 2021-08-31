package order.domain;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


public interface MessagingProcessor<T> {
	default Message<T> message(final T val) {
		return MessageBuilder.withPayload(val).build();
	}
}
