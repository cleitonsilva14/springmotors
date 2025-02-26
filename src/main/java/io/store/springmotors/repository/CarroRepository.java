package io.store.springmotors.repository;

import io.store.springmotors.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, UUID> {

    Optional<CarroModel> findByPlaca(String placa);
    boolean existsByPlaca(String placa);
}
