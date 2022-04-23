package nttdata.bootcamp.microservicios.cliente.natural.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;
import nttdata.bootcamp.microservicios.cliente.natural.repository.TypeNaturalClientRepository;
import nttdata.bootcamp.microservicios.cliente.natural.services.TypeNaturalClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeNaturalLegalClientServiceImpl implements TypeNaturalClientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TypeNaturalLegalClientServiceImpl.class);
	@Autowired
	TypeNaturalClientRepository repository;

	@Override
	public Mono<TypeNaturalClient> findById(String id) {

		return repository.findById(id);
	}

	@Override
	public Flux<TypeNaturalClient> findAlls() {

		return repository.findAll();
	}

	@Override
	public Mono<TypeNaturalClient> saves(TypeNaturalClient document) {

		return repository.save(document);
	}

	@Override
	public Mono<Void> delete(TypeNaturalClient document) {

		return repository.delete(document);
	}

}
