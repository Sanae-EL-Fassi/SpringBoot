package com.nekor.consulting.ecole.webRest;

import com.nekor.consulting.ecole.model.Establishment;
import com.nekor.consulting.ecole.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/establishment")
public class EstablishmentResource {

	@Autowired
	EstablishmentRepository establishmentRepository;

	@PostMapping
	private void createUpdateEstablishment(@RequestBody Establishment establishment) {
		if (establishment.getId() == null) {
			establishment.setId(UUID.randomUUID().toString());
		}
		establishmentRepository.save(establishment);
	}

	@DeleteMapping("{establishmentId}")
	private void createEstablishment(@PathVariable(name = "establishmentId") String establishmentId) {
		establishmentRepository.deleteById(establishmentId);
	}

	@GetMapping
	private Optional<Establishment> findEstablishmentById(
			@RequestParam(name = "establishmentId") String establishmentId) {
		return establishmentRepository.findById(establishmentId);
	}

	@GetMapping("/all")
	private List<Establishment> findEstablishmentId() {
		return establishmentRepository.findAll();
	}

	@GetMapping("/byCity")
	private Optional<Establishment> findEstablishmentByCity(@RequestParam(name = "city") String city) {
		return establishmentRepository.findByCity(city);
	}

}
