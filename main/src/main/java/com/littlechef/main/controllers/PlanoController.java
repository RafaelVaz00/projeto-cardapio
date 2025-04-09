package com.littlechef.main.controllers;

import com.littlechef.main.dtos.PlanoRecordDto;
import com.littlechef.main.models.PlanoModel;
import com.littlechef.main.repositories.PlanoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @PostMapping("/plano")
    public ResponseEntity<PlanoModel> salvarPlano(@RequestBody @Valid PlanoRecordDto planoRecordDto){

        var planoModel = new PlanoModel();
        BeanUtils.copyProperties(planoRecordDto, planoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(planoRepository.save(planoModel));

    }
}
