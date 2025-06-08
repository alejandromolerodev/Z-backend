package zave.molerodev.backend.service;

import java.util.List;
import zave.molerodev.backend.entities.Usuario;

public interface UserService {

    // Busca un usuario por su ID
    Usuario findById(Long id);

    // Guarda un usuario nuevo o actualizado
    Usuario save(Usuario user);

    // Obtiene la lista de todos los usuarios
    List<Usuario> findAll();

    // Elimina un usuario por su ID
    void deleteById(Long id);

    // Busca un usuario por su email
    Usuario findByEmail(String email);

    // Busca un usuario por su username
    Usuario findByUsername(String username);

    // Actualiza los datos de un usuario existente
    Usuario update(Usuario user);
}
