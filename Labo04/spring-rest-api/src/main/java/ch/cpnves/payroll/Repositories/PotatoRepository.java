package ch.cpnves.potatotally.Repositories;

import ch.cpnves.potatotally.Entities.Potato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotatoRepository extends JpaRepository<Potato, Long>{
    
}
