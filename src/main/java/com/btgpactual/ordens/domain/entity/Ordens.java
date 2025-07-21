package com.btgpactual.ordens.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Document("ordens")
public class Ordens {

	@MongoId
	private Long  codigoPedido;
	private Long codigoCliente; 
	private List<Itens> itens;
	@Indexed(name = "customer_id_index")
	private Long customerId;
	
	@Field(targetType = FieldType.DECIMAL128)
	private BigDecimal total;
	
}
