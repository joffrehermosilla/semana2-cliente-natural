package nttdata.bootcamp.microservicios.cliente.natural.services;

import nttdata.bootcamp.microservicios.cliente.natural.documents.NaturalLegalClient;
import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NaturalLegalClientService {

	public Mono<NaturalLegalClient> findById(String id);

	public Flux<NaturalLegalClient> findAlls();

	public Mono<NaturalLegalClient> saves(NaturalLegalClient document);

	public Mono<Void> delete(NaturalLegalClient document);

	public Flux<TypeNaturalClient> findAllTypeNaturalClient();

	public Mono<TypeNaturalClient> findTypeNaturalClientById(String id);

	public Mono<TypeNaturalClient> saveTypeNaturalClient(TypeNaturalClient document);

}
