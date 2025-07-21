package com.btgpactual.ordens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btgpactual.ordens.domain.entity.Ordens;
import com.btgpactual.ordens.service.OrdensService;

@RestController
@RequestMapping("/v1/ordens")
public class OrdensController {

	@Autowired
	private OrdensService service;
	
	@PostMapping("/create")
	public ResponseEntity<Ordens> create(@RequestBody Ordens ordens) {
		return ResponseEntity.ok(service.create(ordens));
	}
	
	@GetMapping("/oi")
	public String get() {
		return "Oi";
	}
	
}
