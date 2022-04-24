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

/*
 * Desarrollo de microservicios con Java 11. • Utilizar Spring Boot Webflux
 * 2.6.x como framework base. • El proyecto debe utilizar Maven como gestor de
 * dependencias. • Los microservicios proporcionados deben implementar
 * controladores REST. • Usar el patrón database per service. • Utilizar
 * inyección de dependencias. • Utilizar propiedades de configuración
 * externalizadas con un Config Server. • Los nombres de las clases, métodos y
 * las URLs deberán estar en inglés. • La base de datos a utilizar será MongoDB.
 * • Uso de Lombok para reducir código. • Manejo de trazas con Logback y
 * utilizar el nivel del log adecuado
 */
/*
 * Elaborar y mantener un diagrama en draw.io con el diseño de la solución. • El
 * repositorio de datos deberá estar en documentos NoSQL. • Para el manejo de
 * datos se deberá utilizar Spring Data y no se deberá manejar la creación de
 * SQL dinámicos y evitar el uso de la anotación
 * 
 * @Query. • Para todas las entidades de negocio se debe implementar sus
 * operaciones CRUD: Create, FindAll, Update, Delete. • Crear los endpoints REST
 * para cada una de las operaciones de los repositorios. • Utilizar los
 * lineamientos REST para las operaciones CRUD. • El sistema no tendrá
 * implementado ninguna interfaz gráfica, la verificación de las funcionalidades
 * se realizarán utilizando Postman. Recomendaciones y Consideraciones • No
 * deben tener configuraciones en el código (hardcode). • Las clases y los
 * métodos deben estar comentados adecuadamente. • El uso de lambdas y streams
 * de Java 11 es requerido. • Deben subir diariamente su código a un repositorio
 * git en github. • Cada pareja deberá presentar su propia solución. Artefactos
 * y entregables. • Crear y mantener un repositorio en donde tengan almacenado
 * su diagrama de solución en draw.io • Crear y mantener un repositorio en donde
 * tengan los proyectos postman para las pruebas de sus APIs. • Todos los días
 * laborables deberán subir el avance de su desarrollo a sus repositorios en
 * github. • Cada microservicio deberá tener su propio repositorio. • L
 * 
 */

/*
 * Cada microservicio deberá estar en un contenedor independiente en Docker. •
 * Crear un microservicio de registro de APIs con Eureka, habilitar su panel de
 * control e implementar el registro de las APIs para todos los microservicios.
 * • Crear un microservicio que sirva como API gateway para APIs con Spring
 * Cloud Gateway. • Implementar circuit braker en los microservicios usando
 * Resilence4j y configurar un timeout de 2 segundos. • Agregar el uso de
 * Checkstyle agreganso su plugin en el pom.xml. • Implementar un servidor de
 * SonarQube para visualizar los reportes de análisis de código de todo el
 * código desarrollado
 */

/*
 * Funcionalidades del sistema Crear APIs implementadas en microservicios que
 * ofrezcan las siguientes funcionalidades: • Se conservarán las funcionalidades
 * definidas para el proyecto 1 • Las cuentas bancarias tienen un monto mínimo
 * de apertura que puede ser cero (0). • El sistema manejará nuevos perfiles de
 * clientes adicionales a los que ya existen, los nuevos perfiles son o
 * Personal:  VIP  Cuenta de ahorro que requiere un monto mínimo de promedio
 * diario cada mes. Adicionalmente, para solicitar este producto el cliente debe
 * tener una tarjeta de crédito con el banco al momento de la creación de la
 * cuenta. o Empresarial:  PYME  Cuenta corriente sin comisión de
 * mantenimiento. Como requisito, el cliente debe tener una tarjeta de crédito
 * con el banco al momento de la creación de la cuenta. • Todas las cuentas
 * bancarias tendrán un número máximo de transacciones (depósitos y retiros) que
 * no cobrará comisión y superado ese número se cobrará comisión por cada
 * transacción realizada. BOOTCAMP BACKEND 2022 • Implementar las transferencias
 * bancarias entre cuentas del mismo cliente y cuentas a terceros del mismo
 * banco. • El sistema debe generar los siguientes reportes: o Para un cliente
 * se debe generar un resumen con los saldos promedio diarios del mes en curso
 * de todos los productos de crédito o cuentas bancarias que posee. • Generar un
 * reporte de todas las comisiones cobradas por producto en un periodo de
 * tiempo. Artefactos y entregables. • Crear y mantener un repositorio en donde
 * tengan almacenado su diagrama de solución en draw.io • Crear y mantener un
 * repositorio en donde tengan los proyectos postman para las pruebas de sus
 * APIs. • Todos los días laborables deberán subir el avance de su desarrollo a
 * sus repositorios en github. • Cada microservicio deberá tener su propio
 * repositorio.
 */


/*
 * Los desarrollos deben continuar con la base de conocimiento requerida en el
 * proyecto anterior, más las que se listan a continuación:  Desarrollo de las
 * nuevas funcionalidades con programación funcional.  Manejo de colecciones
 * utilizando correctamente las APIs para Streams.  Los nuevos métodos públicos
 * creados deberán tener sus respectivas pruebas unitarias con los mocks en
 * aquellos casos donde corresponda.  Es deseable que los microservicios se
 * encuentren desplegados en Azure utilizando GitHub Actions para su despliegue.
 *  Los controladores que implementen las nuevas funcionalidades deberán ser
 * reactivas usando para ella el modelo de Reactor y el framework Spring
 * Webflux. Funcionalidades del sistema  Permitir elaborar un resumen
 * consolidado de un cliente con todos los productos que pueda tener en el
 * banco.  Un cliente no podrá adquirir un producto si posee alguna deuda
 * vencida en algún producto de crédito.  Generar un reporte completo y general
 * por producto del banco en intervalo de tiempo especificado por el usuario. 
 * Un cliente puede hacer el pago de cualquier producto de crédito de terceros.
 *  Los clientes ahora pueden tener tarjetas de débito asociado a sus cuentas
 * bancarias y hacer pagos con ellas.  Un cliente puede asociar la tarjeta de
 * débito a todas las cuentas bancarias que posea.  Toda tarjeta de débito
 * tiene asociada una cuenta principal desde la cual aplicará los retiros o
 * pagos.  En caso de un retiro o pago con tarjeta de débito y no se tenga el
 * saldo suficiente en la cuenta principal, se debe analizar la disponibilidad
 * en las siguientes cuentas asociadas a la tarjeta en el orden en que fueron
 * asociadas a la tarjeta. En el caso que aplique el pago el retiro del
 * movimiento se deberá aplicar en el orden indicado.  Implementar un reporte
 * con los últimos 10 movimientos de la tarjeta de débito y de crédito. 
 * Consultar el saldo de la cuenta principal asociada a la tarjeta de débito.
 * BOOTCAMP BACKEND 2022 Artefactos y entregables. • Crear y mantener un
 * repositorio en donde tengan almacenado su diagrama de solución en draw.io •
 * Crear y mantener un repositorio en donde tengan los proyectos postman para
 * las pruebas de sus APIs. • Todos los días laborables deberán subir el avance
 * de su desarrollo a sus repositorios en github. • Cada microservicio deberá
 * tener su propio repositorio.
 * 
 */