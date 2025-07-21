package com.btgpactual.ordens.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.btgpactual.ordens.domain.entity.Ordens;
import com.btgpactual.ordens.listener.dto.OrderCreatedEvent;
import com.btgpactual.ordens.repository.OrdensRepository;

@Service
public class OrdensService {

	private ModelMapper modelmapper = new ModelMapper();
	
	private final OrdensRepository repository;

    public OrdensService( OrdensRepository repository) {
		this.repository = repository;
    }
	
	public Ordens create(Ordens ordens) {
		return repository.save(ordens);
	}
	
	public Ordens create(OrderCreatedEvent event) {
		return repository.save(modelmapper.map(event, Ordens.class));
	}
	
}
