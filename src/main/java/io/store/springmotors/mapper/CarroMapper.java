package io.store.springmotors.mapper;


import io.store.springmotors.dto.CarroRequestDto;
import io.store.springmotors.dto.CarroResponseDto;
import io.store.springmotors.model.CarroModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class CarroMapper {

    // de CarroRequestDto para CarroModel
    public static CarroModel toCarro(CarroRequestDto carroRequestDto){
        return new ModelMapper().map(carroRequestDto, CarroModel.class);
    }

    // de CarroModel para CarroResponseDto
    public static CarroResponseDto toDto(CarroModel carro){
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<CarroModel, CarroResponseDto> pros = modelMapper.createTypeMap(CarroModel.class, CarroResponseDto.class);
        return modelMapper.map(carro, CarroResponseDto.class);
    }

    // de lista de CarroModel para List de CarroResponseDto
    public static List<CarroResponseDto> toListDto(List<CarroModel> carros){
        return carros.stream().map(carroModel -> toDto(carroModel)).collect(Collectors.toList());
    }


}

