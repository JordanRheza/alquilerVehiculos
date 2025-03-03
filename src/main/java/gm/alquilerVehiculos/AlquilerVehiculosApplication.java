package gm.alquilerVehiculos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlquilerVehiculosApplication {

	private static final Logger logger = LogManager.getLogger(AlquilerVehiculosApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AlquilerVehiculosApplication.class, args);
		logger.info("El api se ejecuto con exito");
	}

}
