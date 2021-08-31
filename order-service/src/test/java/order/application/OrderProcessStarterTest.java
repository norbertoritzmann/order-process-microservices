package order.application;

import common.Order;
import order.infrastructure.EventDispatcher;
import order.infrastructure.OrderProcessStarter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderProcessStarterTest {

	@Mock
	private EventDispatcher dispatcher;

	@InjectMocks
	private OrderProcessStarter processor;

	@Test
	void startProcess() {
		Order order = Mockito.mock(Order.class);

		processor.startProcess(order);

		verify(dispatcher).dispatch(any(), any());
	}

}
