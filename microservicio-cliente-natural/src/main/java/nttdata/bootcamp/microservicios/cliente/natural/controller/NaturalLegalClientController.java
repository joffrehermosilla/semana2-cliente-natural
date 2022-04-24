package nttdata.bootcamp.microservicios.cliente.natural.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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

		TypeNaturalClient typex = new TypeNaturalClient();

		List<TypeNaturalClient> types = new ArrayList<>();

		// Mono<TypeNaturalClient> monotype = typeservice.findById(id); // todavia no
		// puedo obtener .get(i) los elememntos
		// del flujo hago artificios

		if (id.equals("626208bafd7af9601a085afd")) {
			typex.setId(id);
			typex.setTypename("VIP");
			typex.setCreateAt(new Date());
		} else {
			typex.setId(id);
			typex.setTypename("average");
			typex.setCreateAt(new Date());
		}

		/*
		 * monotype.doOnNext(tz -> { if (id.equals("626208bafd7af9601a085afd")) {
		 * typex.setId(id); typex.setTypename("VIP"); typex.setCreateAt(new Date()); }
		 * else { typex.setId(id); typex.setTypename("average"); typex.setCreateAt(new
		 * Date()); } }).onErrorReturn(typex).onErrorResume(e -> Mono.just(typex))
		 * .onErrorMap(f -> new InterruptedException(f.getMessage())) .subscribe(tp ->
		 * LOGGER.info("seteo de Entity Tipo CLiente para la creacion" + tp));
		 * 
		 * 
		 */
		Mono.just(naturals).doOnNext(t -> {
			// t.setTypeNaturalclient(fx);
			types.add(typex);
			t.setListtypeNatural(types);
			t.setType(typex);

			// t.setCreateAt(new Date());

		}).onErrorReturn(naturals).onErrorResume(e -> Mono.just(naturals))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> LOGGER.info(x.toString()));

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
			@PathVariable String id) {

		Mono<TypeNaturalClient> newTypeNaturalPerson = typeservice.findById(id);
		List<TypeNaturalClient> types = new ArrayList<>();

		String lasttypename = type.getTypename();

		Mono.just(type).doOnNext(t -> {
			type.setId(id);

			t.setCreateAt(new Date());

		}).onErrorReturn(type).onErrorResume(e -> Mono.just(type))
				.onErrorMap(f -> new InterruptedException(f.getMessage()))
				.subscribe(x -> LOGGER.info("el valor cambiado es: " + x.toString()));

		newTypeNaturalPerson = typeservice.saves(type);

		// NaturalLegalClient naturalx = new NaturalLegalClient();
		List<NaturalLegalClient> naturals = new ArrayList<>();
		Flux<NaturalLegalClient> fluxnatural = Flux.fromIterable(naturals);
		Flux<NaturalLegalClient> fx2 = fluxnatural;

		fx2.filter(f -> f.getType().getTypename().equals(lasttypename)).flatMap(n -> {
			types.add(type);
			n.setListtypeNatural(types);
			n.setType(type);
			service.saves(n);
			return Mono.just(n);
		}).collectList().onErrorReturn(naturals).onErrorResume(e -> Mono.just(naturals))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> LOGGER.info(x.toString()));

		if (newTypeNaturalPerson != null) {

			return new ResponseEntity<>(newTypeNaturalPerson, HttpStatus.CREATED);

		}

		return new ResponseEntity<>(Mono.just(new NaturalLegalClient()), HttpStatus.I_AM_A_TEAPOT);
	}

	@PutMapping("{naturalClientId}/update-natural-client/{typeNaturalId}")
	public ResponseEntity<Mono<?>> updateeNaturalPerson(@Valid @RequestBody NaturalLegalClient naturals,
			@PathVariable String naturalClientId, @PathVariable String typeNaturalId) {

		// definimos tipo de cliente

		TypeNaturalClient typex = new TypeNaturalClient();

		List<TypeNaturalClient> types = new ArrayList<>();

		if (typeNaturalId.equals("626208bafd7af9601a085afd")) {
			typex.setId(typeNaturalId);
			typex.setTypename("VIP");
			typex.setCreateAt(new Date());
		} else {
			typex.setId(typeNaturalId);
			typex.setTypename("average");
			typex.setCreateAt(new Date());
		}

		/*
		 * Mono<TypeNaturalClient> monotype = typeservice.findById(typeNaturalId);
		 * monotype.doOnNext(tz -> { if
		 * (typeNaturalId.equals("626208bafd7af9601a085afd")) {
		 * typex.setId(typeNaturalId); typex.setTypename("VIP"); typex.setCreateAt(new
		 * Date()); } else { typex.setId(typeNaturalId); typex.setTypename("average");
		 * typex.setCreateAt(new Date()); } }).onErrorReturn(typex).onErrorResume(e ->
		 * Mono.just(typex)) .onErrorMap(f -> new InterruptedException(f.getMessage()))
		 * .subscribe(tp ->
		 * LOGGER.info("seteo de Entity Tipo CLiente para la acutalizacion" + tp));
		 */

		// definos cliente natural
		Mono<NaturalLegalClient> newNaturalPerson = service.findById(naturalClientId);

		Mono.just(naturals).doOnNext(t -> {
			naturals.setId(naturalClientId);
			types.add(typex);
			t.setId(naturalClientId);

			t.setListtypeNatural(types);

			t.setType(typex);

			t.setCreateAt(new Date());

		}).onErrorReturn(naturals).onErrorResume(e -> Mono.just(naturals))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> LOGGER.info(x.toString()));

		newNaturalPerson = service.saves(naturals);

		if (newNaturalPerson != null) {

			return new ResponseEntity<>(newNaturalPerson, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(Mono.just(new NaturalLegalClient()), HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/eliminar-cliente-natural/{id}")
	public ResponseEntity<Mono<Void>> deleteNaturalPerson(@PathVariable String id) {
		NaturalLegalClient natural = new NaturalLegalClient();
		natural.setId(id);
		Mono<NaturalLegalClient> newNaturalPerson = service.findById(id);
		newNaturalPerson.subscribe();
		Mono<Void> test = service.delete(natural);
		test.subscribe();
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/eliminar-tipocliente-natural/{id}")
	public ResponseEntity<Mono<Void>> deleteTypeNaturalPerson(@PathVariable String id) {
		TypeNaturalClient typenatural = new TypeNaturalClient();
		typenatural.setId(id);
		Mono<TypeNaturalClient> newTypeNaturalPerson = typeservice.findById(id);
		newTypeNaturalPerson.subscribe();
		Mono<Void> test = typeservice.delete(typenatural);

		test.subscribe();

		return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<Mono<?>> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
		});

		ResponseEntity.badRequest().body(errores);

		return new ResponseEntity<>(Mono.just(errores), HttpStatus.I_AM_A_TEAPOT);
		// return ResponseEntity.badRequest().body(errores);
	}

}
