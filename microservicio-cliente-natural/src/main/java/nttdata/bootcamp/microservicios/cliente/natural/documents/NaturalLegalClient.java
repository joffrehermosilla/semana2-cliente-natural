package nttdata.bootcamp.microservicios.cliente.natural.documents;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "natural-legal-client")
public class NaturalLegalClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(NaturalLegalClient.class);

	@Id
	private String id;

	private String completename;

	private String dni;

	// clientStatus determinara si el cliente tiene alguna deuda vencida
	private String clientStatus;

//	private Flux<TypeNaturalClient> typeNaturalclient;

	private List<TypeNaturalClient> listtypeNatural;

	private TypeNaturalClient type;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

}
