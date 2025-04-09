package com.littlechef.main.repositories;

import com.littlechef.main.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, UUID> {
}
