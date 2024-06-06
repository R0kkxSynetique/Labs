package ch.cpnves.potatotally.Repositories;

import ch.cpnves.potatotally.Entities.Potato;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PotatoRepository repository){
        return args->{
            log.info("Preloading " + repository.save(new Potato("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Potato("Frodo Baggins", "thief")));
        };
    }
}
