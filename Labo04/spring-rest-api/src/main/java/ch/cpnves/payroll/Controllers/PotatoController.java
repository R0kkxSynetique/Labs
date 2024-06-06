package ch.cpnves.potatotally.Controllers;

import ch.cpnves.potatotally.Repositories.PotatoRepository;
import ch.cpnves.potatotally.Entities.Potato;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PotatoController {

    private final PotatoRepository repository;

    PotatoController(PotatoRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/potatoes
    */
    @GetMapping("/potatoes")
    List<Potato> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/potatoes ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Russel George\", \"role\": \"gardener\"}"
    */
    @PostMapping("/potatoes")
    Potato newPotato(@RequestBody Potato newPotato){
        return repository.save(newPotato);
    }

    /* curl sample :
    curl -i localhost:8080/potatoes/1
    */
    @GetMapping("/potatoes/{id}")
    Potato one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new PotatoNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/potatoes/2 ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Samwise Bing\", \"role\": \"peer-to-peer\"}"
     */
    @PutMapping("/potatoes/{id}")
    Potato replacePotato(@RequestBody Potato newPotato, @PathVariable Long id) {
        return repository.findById(id)
                .map(potato -> {
                    potato.setName(newPotato.getName());
                    potato.setRole(newPotato.getRole());
                    return repository.save(potato);
                })
                .orElseGet(() -> {
                    newPotato.setId(id);
                    return repository.save(newPotato);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/potatoes/2
    */
    @DeleteMapping("/potatoes/{id}")
    void deletePotato(@PathVariable Long id){
        repository.deleteById(id);
    }
}
