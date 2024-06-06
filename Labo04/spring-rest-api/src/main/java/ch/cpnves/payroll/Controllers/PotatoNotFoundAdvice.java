package ch.cpnves.potatotally.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PotatoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PotatoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String potatoNotFoundHandler(PotatoNotFoundException ex){
        return ex.getMessage();
    }
}
