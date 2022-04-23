package nttdata.bootcamp.microservicios.cliente.natural.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;

@Repository
public interface TypeNaturalClientRepository extends ReactiveMongoRepository<TypeNaturalClient, String> {

}
