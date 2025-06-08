package zave.molerodev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zave.molerodev.backend.entities.Usuario;
import zave.molerodev.backend.repository.UserRepository;

@Service
public class UserService_Impl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    // Busca un usuario por su ID
    @Override
    public Usuario findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Busca un usuario por su email
    @Override
    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // Busca un usuario por su username
    @Override
    public Usuario findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // Actualiza los datos de un usuario existente
    @Override
    public Usuario update(Usuario user) {
        Usuario existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setRol(user.getRol());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }
    
    // Guarda un usuario nuevo o actualizado
    @Override
    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    // Obtiene la lista de todos los usuarios
    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    // Elimina un usuario por su ID
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
