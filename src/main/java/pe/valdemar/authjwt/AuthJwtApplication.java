package pe.valdemar.authjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pe.valdemar.authjwt.model.TokenProperties;

@SpringBootApplication
@EnableConfigurationProperties(TokenProperties.class)
public class AuthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthJwtApplication.class, args);
	}

}
