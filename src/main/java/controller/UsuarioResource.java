package controller;

import dao.UsuarioDaoService;
import exception.UsuarioNaoEncontrado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import model.Usuario;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
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
        Usuario usuario = usuarioDaoService.findOne(id);

        if(usuario==null)
            throw new UsuarioNaoEncontrado("id: " + id);

        return usuario;
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuario(@PathVariable int id) {
        usuarioDaoService.deleteById(id);
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioDaoService.save(usuario);
        URI local = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(local).build();
    }
}
