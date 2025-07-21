package com.btgpactual.ordens.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btgpactual.ordens.domain.entity.Ordens;
import com.btgpactual.ordens.repository.OrdensRepository;

@Service
public class OrdensService {

	@Autowired
	private OrdensRepository repository;
	
	public Ordens create(Ordens ordens) {
		return repository.save(ordens);
	}
	
	private BigDecimal getTotal(Ordens ordens) {
		return ordens.getItens().stream()
		.map(i -> i.getPreco().multiply(BigDecimal.valueOf(i.getQuantidade()))).reduce(BigDecimal::add)
		.orElse(BigDecimal.ZERO);
	}
}
