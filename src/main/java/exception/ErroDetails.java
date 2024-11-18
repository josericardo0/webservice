package exception;

import java.time.LocalDateTime;

public class ErroDetails {

    private LocalDateTime timestamp;
    private String mensagem;
    private String detalhes;

    public ErroDetails(LocalDateTime timestamp, String mensagem, String detalhes) {
        this.timestamp = timestamp;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
