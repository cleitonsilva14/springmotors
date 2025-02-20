package io.store.springmotors.controller;

import io.store.springmotors.dto.CarroRequestDto;
import io.store.springmotors.dto.CarroResponseDto;
import io.store.springmotors.mapper.CarroMapper;
import io.store.springmotors.model.CarroModel;
import io.store.springmotors.service.CarroService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroService carroService;


    @GetMapping
    public ResponseEntity<List<CarroResponseDto>> getAll(){
        List<CarroModel> carros = carroService.findAllCarros();
        return ResponseEntity.status(HttpStatus.OK).body(CarroMapper.toListDto(carros));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Object> findByUUID(@RequestParam UUID uuid){

        Optional<CarroModel> carroModelOptional = carroService.findCarroByUUID(uuid);
        if(carroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(carroModelOptional.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(uuid + "não encontrado!");

    }

    @PostMapping("/all")
    public ResponseEntity<List<CarroModel>> saveAll(@RequestBody @Valid List<CarroRequestDto> carroRequestDtoList){

        // return carros.stream().map(carroModel -> toDto(carroModel)).collect(Collectors.toList());

        List<CarroModel> carros =  carroRequestDtoList.stream()
                .map(carroRequestDto -> CarroMapper.toCarro(carroRequestDto))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(carroService.saveAll(carros));

    }

    @PostMapping
    public ResponseEntity<CarroResponseDto> save(@RequestBody @Valid CarroRequestDto carroRequestDto){
        CarroModel carro = carroService.saveCar(CarroMapper.toCarro(carroRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CarroMapper.toDto(carro));
    }


}
