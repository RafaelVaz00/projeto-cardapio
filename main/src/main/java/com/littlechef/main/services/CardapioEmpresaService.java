package com.littlechef.main.services;

import com.littlechef.main.models.CardapioEmpresaModel;
import com.littlechef.main.repositories.CardapioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Service
public class CardapioEmpresaService {
    @Autowired
    private CardapioEmpresaRepository cardapioEmpresaRepository;

    public CardapioEmpresaModel buscarCardapioEmpresa(Integer id){
        Optional<CardapioEmpresaModel> cardapio = cardapioEmpresaRepository.findById(id);

        if(cardapio.isPresent()){
            return cardapio.get();
        }
        return null;
    }

    public CardapioEmpresaModel salvarCardapioEmpresa(CardapioEmpresaModel cardapio){

        return cardapioEmpresaRepository.save(cardapio);

    }

}
