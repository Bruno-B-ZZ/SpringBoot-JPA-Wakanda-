package Projeto_spring.Repository;

import Projeto_spring.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

List<Usuario> listAll();


}
