package nttdata.bootcamp.microservicios.cliente.natural.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nttdata.bootcamp.microservicios.cliente.natural.documents.NaturalLegalClient;
import nttdata.bootcamp.microservicios.cliente.natural.documents.TypeNaturalClient;
import nttdata.bootcamp.microservicios.cliente.natural.services.NaturalLegalClientService;
import nttdata.bootcamp.microservicios.cliente.natural.services.TypeNaturalClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NaturalLegalClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NaturalLegalClientController.class);

	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@Autowired
	private NaturalLegalClientService service;

	@Autowired
	private TypeNaturalClientService typeservice;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceador", balanceadorTest);
		response.put("cursos", service.findAlls());
		return ResponseEntity.ok(response);

	}

	@GetMapping("/all")
	public Flux<NaturalLegalClient> searchAll() {
		Flux<NaturalLegalClient> nat = service.findAlls();
		LOGGER.info("NATURAL LEGAL CLIENT registered: " + nat);
		return nat;
	}

	@GetMapping("/type-all")
	public Flux<TypeNaturalClient> searchAllTypes() {
		Flux<TypeNaturalClient> type = typeservice.findAlls();
		LOGGER.info("NATURAL LEGAL CLIENT registered: " + type);
		return type;
	}

	@GetMapping("/id/{id}")
	public Mono<NaturalLegalClient> searchById(@PathVariable String id) {
		LOGGER.info("NATURAL LEGAL CLIENT id: " + service.findById(id) + " con codigo: " + id);
		return service.findById(id);
	}

	/*
	 * @PostMapping("/create-natural-client") public Mono<NaturalLegalClient>
	 * createNaturalLegalClient(
	 * 
	 * @Valid @RequestBody NaturalLegalClient naturalLegalCLient) {
	 * LOGGER.info("NATURAL LEGAL CLIENT create: " +
	 * service.saves(naturalLegalCLient)); return service.saves(naturalLegalCLient);
	 * }
	 */

	@PostMapping("/create-natural-response/{id}")
	public ResponseEntity<Mono<?>> newNaturalPerson(@PathVariable String id,
			@Valid @RequestBody NaturalLegalClient naturals) {

		// TypeNaturalClient typex = new TypeNaturalClient();

		List<TypeNaturalClient> types = new ArrayList<>();

		Mono<TypeNaturalClient> monotype = typeservice.findById(id);

		monotype.subscribe(tp -> types.add(tp));
		// typex.setId(id);

		/*
		 * Flux<TypeNaturalClient> fx = Flux.fromIterable(types);
		 * 
		 * Flux.fromIterable(types).filter(tp -> tp.getId().equals(id)).doOnNext(tipo ->
		 * {
		 * 
		 * // naturals.setTypeNaturalclient(fx);
		 * 
		 * }).subscribe(y -> LOGGER.info(y.toString()));
		 */

		Mono.just(naturals).doOnNext(t -> {
			// t.setTypeNaturalclient(fx);
			t.setListtypeNatural(types);
			// t.setType(typex);
			t.setCreateAt(new Date());

		}).subscribe(x -> LOGGER.info(x.toString()));

		Mono<NaturalLegalClient> newNaturalPerson = service.saves(naturals);

		if (newNaturalPerson != null) {

			return new ResponseEntity<>(newNaturalPerson, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(Mono.just(new NaturalLegalClient()), HttpStatus.I_AM_A_TEAPOT);
	}

	@PostMapping("/create-type-client")
	public Mono<TypeNaturalClient> createTypeNaturalLegalClient(
			@Valid @RequestBody TypeNaturalClient typenaturalLegalCLient) {
		LOGGER.info("TYPE NATURAL LEGAL CLIENT create: " + typeservice.saves(typenaturalLegalCLient));
		typenaturalLegalCLient.setCreateAt(new Date());

		return typeservice.saves(typenaturalLegalCLient);
	}

	@PutMapping("/update-type-client/{id}")
	public ResponseEntity<Mono<?>> updateTypeNaturalPerson(@Valid @RequestBody TypeNaturalClient type,
			BindingResult result, @PathVariable String id) {

		Mono.just(type).doOnNext(t -> {

			t.setCreateAt(new Date());

		}).subscribe(x -> LOGGER.info(x.toString()));

		Mono<TypeNaturalClient> newTypeNaturalPerson = typeservice.saves(type);

		if (newTypeNaturalPerson != null) {

			return new ResponseEntity<>(newTypeNaturalPerson, HttpStatus.CREATED);

		}

		return new ResponseEntity<>(Mono.just(new NaturalLegalClient()), HttpStatus.I_AM_A_TEAPOT);
	}
	@PutMapping("/update-type-client/{typeNaturalid}/update-natural-client/{naturalClientId}")
	public ResponseEntity<Mono<?>> updateeNaturalPerson(@Valid @RequestBody TypeNaturalClient type,
			BindingResult result, @PathVariable String id) {

		Mono.just(type).doOnNext(t -> {

			t.setCreateAt(new Date());

		}).subscribe(x -> LOGGER.info(x.toString()));

		Mono<TypeNaturalClient> newTypeNaturalPerson = typeservice.saves(type);

		if (newTypeNaturalPerson != null) {

			return new ResponseEntity<>(newTypeNaturalPerson, HttpStatus.CREATED);

		}

		return new ResponseEntity<>(Mono.just(new NaturalLegalClient()), HttpStatus.I_AM_A_TEAPOT);
	}
}
