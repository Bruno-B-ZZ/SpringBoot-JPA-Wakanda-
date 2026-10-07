package Projeto_spring.Controller;

import Projeto_spring.Service.UsuarioService;
import Projeto_spring.Util.DateUtil;
import Projeto_spring.Domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
@Log4j2
public class UsuarioController{

   //public UsuarioController(DateUtil du){
   //     this.date_util = du;
   // }
    @Autowired
    private final DateUtil date_util;
    private final UsuarioService usuario_service;
    //localhost:3306/usuario/lista

   // @RequestMapping
    @GetMapping
  public ResponseEntity<List<Usuario>> lista(){
      log.info(date_util.formatLcalDateTime(LocalDateTime.now()));
      return ResponseEntity.ok(usuario_service.listAll());

  }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        log.info(date_util.formatLcalDateTime(LocalDateTime.now()));
        return ResponseEntity.ok(usuario_service.findById(id));

    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        log.info(date_util.formatLcalDateTime(LocalDateTime.now()));
        return new ResponseEntity<>(usuario_service.save(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        usuario_service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Usuario> replace(@RequestBody Usuario usuario){
        log.info(date_util.formatLcalDateTime(LocalDateTime.now()));
        return new ResponseEntity<>(usuario_service.replace(usuario), HttpStatus.NO_CONTENT);
    }


}