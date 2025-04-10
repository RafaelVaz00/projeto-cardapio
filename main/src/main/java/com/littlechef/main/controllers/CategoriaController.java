package com.littlechef.main.controllers;

import com.littlechef.main.dtos.CategoriaRecordDto;
import com.littlechef.main.models.CategoriaModel;
import com.littlechef.main.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaModel> salvarPlano(@Valid @RequestBody CategoriaRecordDto categoriaDto){

        CategoriaModel categoriaModel = new CategoriaModel();

        BeanUtils.copyProperties(categoriaDto, categoriaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criarUsuario(categoriaModel));
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaModel>> listarCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listarCategorias());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaModel> buscarCategoriaPorId(@PathVariable(value = "id") Integer id){

        CategoriaModel categoria = categoriaService.buscarUsuarioPorId(id);

        if(categoria != null){
            return ResponseEntity.status(HttpStatus.OK).body(categoria);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Object> atualizarCategoria(@PathVariable(value = "id")
                                                             Integer id,
                                                             @Valid @RequestBody CategoriaRecordDto categoriaRecordDto){
        CategoriaModel categoria = new CategoriaModel();
        BeanUtils.copyProperties(categoriaRecordDto, categoria);

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizarCategoria(id, categoria));
    }

    @DeleteMapping("categoria/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "id") Integer id){
        return categoriaService.deletarCategoria(id);
    }
}
