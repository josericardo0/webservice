package model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Usuario {

    private Integer id;

    @Size(min=2, message = "O nome precisa ter no minimo 2 caracteres")
    private String nome;

    @Past(message = "A data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

    public Usuario(Integer id, String nome, LocalDate dataNascimento) {
        super();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
    }
}
