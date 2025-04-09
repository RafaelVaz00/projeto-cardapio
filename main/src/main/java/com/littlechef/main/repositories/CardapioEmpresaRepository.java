package com.littlechef.main.repositories;

import com.littlechef.main.models.CardapioEmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioEmpresaRepository extends JpaRepository<CardapioEmpresaModel, Integer> {
}
