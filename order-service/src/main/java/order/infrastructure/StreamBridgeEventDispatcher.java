package order.infrastructure;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
public class StreamBridgeEventDispatcher implements EventDispatcher {

	private final StreamBridge streamBridge;

	public StreamBridgeEventDispatcher createInstance(StreamBridge streamBridge) {
		return new StreamBridgeEventDispatcher(streamBridge);
	}

	private StreamBridgeEventDispatcher(StreamBridge streamBridge) {
		this.streamBridge = streamBridge;
	}

	@Override
	public <T> boolean dispatch(final String topic, final Message<T> message) {
		return streamBridge.send(topic, message);
	}
}
