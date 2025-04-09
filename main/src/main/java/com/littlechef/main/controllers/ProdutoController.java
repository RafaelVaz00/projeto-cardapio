package com.littlechef.main.controllers;

import com.littlechef.main.dtos.ProdutoRecordDto;
import com.littlechef.main.repositories.ProdutoRepository;
import com.littlechef.main.models.ProdutoModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/produto")
    public ResponseEntity<ProdutoModel> salvarproduto(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {

        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoRecordDto, produtoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }


}
