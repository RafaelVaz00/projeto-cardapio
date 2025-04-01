package com.littlechef.main.Repositories;

import com.littlechef.main.models.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CargoRepository extends JpaRepository<CargoModel, UUID> {
}
