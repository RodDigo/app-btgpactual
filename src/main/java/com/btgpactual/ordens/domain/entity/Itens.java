package com.btgpactual.ordens.domain.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

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
@Document("itens")
public class Itens {
	private String produto;
	private Integer quantidade;
	
	@Field(targetType = FieldType.DECIMAL128)
	private BigDecimal preco;
}
