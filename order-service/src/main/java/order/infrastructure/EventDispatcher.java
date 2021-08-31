package order.infrastructure;

import org.springframework.messaging.Message;


public interface EventDispatcher {

	<T> boolean dispatch(String topic, Message<T> message);
}
