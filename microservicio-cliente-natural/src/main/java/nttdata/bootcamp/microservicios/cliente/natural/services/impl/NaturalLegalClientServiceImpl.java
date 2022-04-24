package nttdata.bootcamp.microservicios.cliente.natural.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nttdata.bootcamp.microservicios.cliente.natural.documents.NaturalLegalClient;
import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;
import nttdata.bootcamp.microservicios.cliente.natural.repository.NaturalLegalClientRepository;
import nttdata.bootcamp.microservicios.cliente.natural.services.NaturalLegalClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NaturalLegalClientServiceImpl implements NaturalLegalClientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NaturalLegalClientServiceImpl.class);
	@Autowired
	NaturalLegalClientRepository repository;

	@Override
	public Mono<NaturalLegalClient> findById(String id) {

		return repository.findById(id);
	}

	@Override
	public Flux<NaturalLegalClient> findAlls() {

		return repository.findAll();
	}

	@Override
	public Mono<NaturalLegalClient> saves(NaturalLegalClient document) {

		return repository.save(document);
	}

	@Override
	public Mono<Void> delete(NaturalLegalClient document) {

		return repository.delete(document);
	}

	@Override
	public Flux<TypeNaturalClient> findAllTypeNaturalClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<TypeNaturalClient> findTypeNaturalClientById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<TypeNaturalClient> saveTypeNaturalClient(TypeNaturalClient document) {
		// TODO Auto-generated method stub
		return null;
	}



}
