package io.store.springmotors.service;


import io.store.springmotors.dto.CarroResponseDto;
import io.store.springmotors.exception.PlacaUniqueViolationException;
import io.store.springmotors.model.CarroModel;
import io.store.springmotors.repository.CarroRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    @Transactional(readOnly = true)
    public List<CarroModel> findAllCarros(){
        return carroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<CarroModel> findCarroByUUID(UUID uuid){
        return carroRepository.findById(uuid);
    }

    @Transactional
    public CarroModel saveCar(CarroModel car) {

        if (carroRepository.existsByPlaca(car.getPlaca())) {
            throw new PlacaUniqueViolationException(String.format("placa [%s] já cadastrada", car.getPlaca()));
        }
        return carroRepository.save(car);



    }

    @Transactional
    public List<CarroModel> saveAll(List<CarroModel> carros) {
        return carroRepository.saveAll(carros);
    }
}
