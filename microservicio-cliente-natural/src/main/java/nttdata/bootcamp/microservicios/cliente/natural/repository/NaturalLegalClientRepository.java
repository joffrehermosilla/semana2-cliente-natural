package nttdata.bootcamp.microservicios.cliente.natural.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import nttdata.bootcamp.microservicios.cliente.natural.documents.NaturalLegalClient;

@Repository
public interface NaturalLegalClientRepository extends ReactiveMongoRepository<NaturalLegalClient, String> {

}
