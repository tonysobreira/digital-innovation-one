package digitalinnovation.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = SoldadoNotFoundException.class)
	public void soldadoNotFoundException() {

	}

}
