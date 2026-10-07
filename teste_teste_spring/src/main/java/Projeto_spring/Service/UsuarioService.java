package Projeto_spring.Service;

import Projeto_spring.Domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioService {

    private static List<Usuario> usuarios;
   static {
       usuarios = new ArrayList<>(List.of(new Usuario(1, "Ana", "Masc", 2000.00), new Usuario(2, "Carlos", "Fem", 2050.00)));

   }
    public List<Usuario> listAll(){
     return usuarios;

}
    public Usuario findById(Long id){
     return usuarios.stream().filter(usuario -> Objects.equals(usuario.getId(), id))
             .findFirst()
             .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuario não existe"));
    }

    public Usuario save(Usuario usuario){
        usuario.setId(ThreadLocalRandom.current().nextLong(3,1000000000));
        usuarios.add(usuario);
       return usuario;
    }
    public void delete(Long id){
       usuarios.remove(findById(id));

}
    public Usuario replace(Usuario usuario){
        delete(usuario.getId());
        usuarios.add(usuario);
        return usuario;
    }


}