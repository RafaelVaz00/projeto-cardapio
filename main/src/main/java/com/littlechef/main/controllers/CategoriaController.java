package com.littlechef.main.controllers;

import com.littlechef.main.dtos.CategoriaRecordDto;
import com.littlechef.main.models.CategoriaModel;
import com.littlechef.main.repositories.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaModel> salvarPlano(@Valid @RequestBody CategoriaRecordDto categoriaDto){

        CategoriaModel categoriaModel = new CategoriaModel();
        //CategoriaService categoriaService = new CategoriaService();

        BeanUtils.copyProperties(categoriaDto, categoriaModel);
        //categoriaService.criarUsuario(categoriaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoriaModel));
    }
}
