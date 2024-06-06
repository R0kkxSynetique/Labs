package ch.cpnves.potatotally.Controllers;

public class PotatoNotFoundException extends RuntimeException{

    PotatoNotFoundException(Long id){
        super("Could not find employee " + id);
    }
}
