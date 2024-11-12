package controller;

import dao.UsuarioDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import util.Usuario;

import java.net.URI;
import java.util.List;

@RestController
public class UsuarioResource {

    private final UsuarioDaoService usuarioDaoService;

    public UsuarioResource(UsuarioDaoService(UsuarioDaoService usuarioDaoService) {
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
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioDaoService.save(usuario);
        URI local = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(local).build();
    }
}
