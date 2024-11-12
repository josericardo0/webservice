package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontrado extends RuntimeException {

    public UsuarioNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}

