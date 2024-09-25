package dao;

import org.springframework.stereotype.Component;
import util.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UsuarioDaoService {

    private static int usersCount = 0;

    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario(++usersCount,"Datena", LocalDate.now().minusYears(68)));
        usuarios.add(new Usuario(++usersCount,"Pablo Marcal", LocalDate.now().minusYears(42)));
        usuarios.add(new Usuario(++usersCount, "Tabata Amaral", LocalDate.now().minusYears(31)));
        usuarios.add(new Usuario(++usersCount, "Guilherme Boulos", LocalDate.now().minusYears(40)));
    }

    public List<Usuario> findAll() {
        return usuarios;
    }

    public Usuario findOne(int id) {
        Predicate<? super Usuario> predicate = usuario -> usuario.getId().equals(id);
        return usuarios.stream().filter(predicate).findFirst().get();
    }

    public Usuario save(Usuario usuario) {
        usuario.setId(++usersCount);
        usuarios.add(usuario);
        return usuario;
    }


}
