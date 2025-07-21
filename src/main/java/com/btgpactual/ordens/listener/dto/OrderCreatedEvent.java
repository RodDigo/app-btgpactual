package com.btgpactual.ordens.listener.dto;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido, Long codigoCliente, List<ItensEvent> itens) {
	
}
