package io.github.kaurhuko.lennuplaneerija;

import io.github.kaurhuko.lennuplaneerija.lennud.Lend;
import io.github.kaurhuko.lennuplaneerija.lennud.LendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class LennuPlaneerijaApplication {

	private static final Logger log = LoggerFactory.getLogger(LennuPlaneerijaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LennuPlaneerijaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(LendRepository repository) {
		return args -> {

			log.info("Preloading: " + repository.save(
					new Lend("AA123", "airBaltic", "TLL", "RIX",
							LocalDateTime.of(2025, 4, 1, 12, 30),
							LocalDateTime.of(2025, 4, 1, 14, 0))));

			log.info("Preloading: " + repository.save(
					new Lend("BB234", "airBaltic", "RIX", "FRA",
							LocalDateTime.of(2025, 4, 1, 18, 0),
							LocalDateTime.of(2025, 4, 1, 21, 0))));

		};
	}

}
