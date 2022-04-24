package nttdata.bootcamp.microservicios.cliente.natural.services;

import nttdata.bootcamp.microservicios.cliente.natural.documents.NaturalLegalClient;
import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeNaturalClientService {

	public Mono<TypeNaturalClient> findById(String id);

	public Flux<TypeNaturalClient> findAlls();

	public Mono<TypeNaturalClient> saves(TypeNaturalClient document);

	public Mono<Void> delete(TypeNaturalClient document);

	public Flux<NaturalLegalClient> findbyName(String typenaturalId);
}
