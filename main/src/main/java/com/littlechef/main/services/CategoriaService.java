package com.littlechef.main.services;


import com.littlechef.main.models.CategoriaModel;
import com.littlechef.main.repositories.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel criarUsuario(CategoriaModel categoria){

        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> listarCategorias(){
        return categoriaRepository.findAll();
    }


    public CategoriaModel buscarUsuarioPorId(Integer id){
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);

        if(categoria.isPresent()){
            return categoria.get();
        }

       return null;
    }

    public CategoriaModel atualizarCategoria(Integer id, CategoriaModel categoria){

        Optional<CategoriaModel> categoriaO = categoriaRepository.findById(id);

        if(categoriaO.isEmpty()){
            return null;
        }
        var categoriaAtualizada = categoriaO.get();
        BeanUtils.copyProperties(categoria, categoriaAtualizada, "idCategoria");
        categoriaAtualizada.setIdCategoria(categoriaO.get().getIdCategoria());
        return categoriaRepository.save(categoriaAtualizada);
    }

    public ResponseEntity<Object> deletarCategoria(Integer id){
        Optional<CategoriaModel> categoriaO = categoriaRepository.findById(id);

        if (categoriaO.isPresent()) {
            categoriaRepository.delete(categoriaO.get());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Categoria removida com sucesso");
    }

}
