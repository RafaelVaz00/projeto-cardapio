package com.littlechef.main.controllers;

import com.littlechef.main.dtos.CardapioEmpresaDto;
import com.littlechef.main.models.CardapioEmpresaModel;
import com.littlechef.main.services.CardapioEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardapioEmpresaController {
    @Autowired
    CardapioEmpresaService cardapioEmpresaService = new CardapioEmpresaService();

    @PostMapping("/cardapio")
    public ResponseEntity<CardapioEmpresaModel> salvarCardapio(@RequestBody @Valid CardapioEmpresaDto cardapioEmpresaDto){

        var cardapioModel = new CardapioEmpresaModel();
        BeanUtils.copyProperties(cardapioEmpresaDto, cardapioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioEmpresaService.salvarCardapioEmpresa(cardapioModel));
    }

    @GetMapping("/cardapio/{id}")
    public ResponseEntity<CardapioEmpresaModel> buscarCardapioPorId(@PathVariable Integer id){

        CardapioEmpresaModel cardapio = cardapioEmpresaService.buscarCardapioEmpresa(id);

        if (cardapio.getIdCardapio() != null) {
            ResponseEntity.status(HttpStatus.OK).body(cardapio);
        }
        return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(cardapio);
    }

}
