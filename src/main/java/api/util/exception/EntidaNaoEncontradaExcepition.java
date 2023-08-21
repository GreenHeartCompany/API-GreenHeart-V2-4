package api.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidaNaoEncontradaExcepition extends RuntimeException{
    public EntidaNaoEncontradaExcepition(String message){
        super (message);
    }
}
