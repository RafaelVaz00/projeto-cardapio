package com.littlechef.main.services;

import com.littlechef.main.models.CardapioEmpresaModel;
import com.littlechef.main.repositories.CardapioEmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardapioEmpresaService {
    @Autowired
    private CardapioEmpresaRepository cardapioEmpresaRepository;

    public CardapioEmpresaModel buscarCardapioEmpresaPorId(Integer id){
        Optional<CardapioEmpresaModel> cardapio = cardapioEmpresaRepository.findById(id);

        if(cardapio.isPresent()){
            return cardapio.get();
        }
        return null;
    }

    public CardapioEmpresaModel salvarCardapioEmpresa(CardapioEmpresaModel cardapio){

        return cardapioEmpresaRepository.save(cardapio);

    }

    public CardapioEmpresaModel atualizarCardapio(Integer id, CardapioEmpresaModel cardapioEmpresaModel){
        Optional<CardapioEmpresaModel> cardapioO = cardapioEmpresaRepository.findById(id);


        if(cardapioO.isPresent()){
            BeanUtils.copyProperties(cardapioEmpresaModel, cardapioO, "idCardapio");
            return cardapioEmpresaRepository.save(cardapioO.get());
        }
        return null;
    }


    public ResponseEntity<Object> deletarCardapio(Integer id){

        Optional<CardapioEmpresaModel> cardapioO = cardapioEmpresaRepository.findById(id);

            if(cardapioO.isEmpty()){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Categoria não existente.");
            }
            cardapioEmpresaRepository.delete(cardapioO.get());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("A categoria de Id" + cardapioO.get().getIdCardapio() + " foi deletada com sucesso.");
    }
}
