package com.littlechef.main.controllers;

import com.littlechef.main.dtos.UsuarioRecordDto;
import com.littlechef.main.repositories.UsuarioRepository;
import com.littlechef.main.models.UsuarioModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> buscarUsuarioPorId(@PathVariable(value="id") UUID id){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable(value="id") UUID id,
                                                   @RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(id);
        if(usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        var usuarioModel = usuarioO.get();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
    }

    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value="id") UUID id) {

        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(id);

        if(usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encotnrado.");
        }
        var usuarioModel = usuarioO.get();
        usuarioRepository.delete(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }

}
