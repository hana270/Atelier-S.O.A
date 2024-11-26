package projet.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import projet.spring.entities.Ingredient;
import projet.spring.entities.Recette;


@SpringBootApplication
public class AtelierSecuriserApiKeycloackApplication  implements CommandLineRunner{

	
		@Autowired
		private RepositoryRestConfiguration repositoryRestConfiguration;

		public static void main(String[] args) {
			SpringApplication.run(AtelierSecuriserApiKeycloackApplication.class, args);
		}
		
		@Override
		public void run(String... args) throws Exception {
			repositoryRestConfiguration.exposeIdsFor(Ingredient.class);
			repositoryRestConfiguration.exposeIdsFor(Recette.class);
		}

	}
