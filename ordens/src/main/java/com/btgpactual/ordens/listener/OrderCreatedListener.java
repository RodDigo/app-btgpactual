package com.btgpactual.ordens.listener;

import static com.btgpactual.ordens.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.btgpactual.ordens.listener.dto.OrderCreatedEvent;

@Component
public class OrderCreatedListener {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(OrderCreatedListener.class);
	
	@RabbitListener(queues = ORDER_CREATED_QUEUE)
	public void listen(Message<OrderCreatedEvent> message) {
		logger.info("Message Consumed {}", message);
	}
	
}
