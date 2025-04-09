package com.littlechef.main.services;


import com.littlechef.main.models.CategoriaModel;
import com.littlechef.main.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel criarUsuario(CategoriaModel categoria){

        return categoriaRepository.save(categoria);
    }
}
