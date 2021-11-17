package sistemainformacion.registroproyectos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@EntityScan(basePackages = {"sistemainformacion.registroproyectos.Model"})
@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
public class RegistroProyectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroProyectosApplication.class, args);
	}

}
