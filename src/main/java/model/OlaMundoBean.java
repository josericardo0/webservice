package model;

public class OlaMundoBean {

    private String mensagem;

    public OlaMundoBean(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
      return "OlaMundoBean [mensagem=" + mensagem + "]";
    }
}

