package nttdata.bootcamp.microservicios.cliente.natural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MicroservicioClienteNaturalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteNaturalApplication.class, args);
	}

}


//actualizacion en github actions