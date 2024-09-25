package controller;

import dao.UsuarioDaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.Usuario;

import java.util.List;

@RestController
public class UsuarioResource {

    private final UsuarioDaoService usuarioDaoService;

    public UsuarioResource(UsuarioDaoService usuarioDaoService) {
        this.usuarioDaoService = usuarioDaoService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> retornarTodosOsUsuarios() {
        return usuarioDaoService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario retornarUsuarioPorId(@PathVariable int id) {
        return usuarioDaoService.findOne(id);
    }

    @PostMapping("/criar-usuario")
    public void createUser(@RequestBody Usuario usuario) {
        usuarioDaoService.save(usuario);
        ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }
}
