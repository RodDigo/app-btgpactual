package com.btgpactual.ordens.listener;

import static com.btgpactual.ordens.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.btgpactual.ordens.domain.entity.Itens;
import com.btgpactual.ordens.domain.entity.Ordens;
import com.btgpactual.ordens.listener.dto.ItensEvent;
import com.btgpactual.ordens.listener.dto.OrderCreatedEvent;
import com.btgpactual.ordens.service.OrdensService;

@Component
public class OrderCreatedListener {
	private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

	@Autowired
	private OrdensService service;
	
	@RabbitListener(queues = ORDER_CREATED_QUEUE)
	public void listen(Message<OrderCreatedEvent> message) {
		logger.info("Message Consumed {}", message);
		
		OrderCreatedEvent payload = message.getPayload();
		
		service.create(Ordens.builder()
				.codigoCliente(payload.codigoCliente())
				.codigoPedido(payload.codigoPedido())
				.total(getTotal(payload.itens()))
				.itens(payload.itens().stream().map(i -> new Itens(i.produto(), i.quantidade(), i.preco())).toList())
				.build());
	}
	
	private BigDecimal getTotal(List<ItensEvent> itens) {
		return itens.stream()
		.map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade()))).reduce(BigDecimal::add)
		.orElse(BigDecimal.ZERO);
	}
}
