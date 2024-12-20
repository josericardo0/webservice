package exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseEntityExceptionHandlerCustomizado extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErroDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {

        ErroDetails erroDetails = new ErroDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErroDetails>(erroDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    public final ResponseEntity<ErroDetails> UsuarioNaoEncontradoException(Exception ex, WebRequest request) throws Exception {

        ErroDetails erroDetails = new ErroDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErroDetails>(erroDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErroDetails erroDetails = new ErroDetails(LocalDateTime.now(),"Total de erros: " + ex.getErrorCount() + "Primeiro erro: " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

        return new ResponseEntity<ErroDetails>(erroDetails, HttpStatus.BAD_REQUEST);

    }

}
