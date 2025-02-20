package io.store.springmotors.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class CarroResponseDto{
    UUID uuid;
    String marca;
    String modelo;
    int ano;
    double km;
    String cor;
    String placa;
    BigDecimal preco;
    Float motor;
    String cambio;
    String combustivel;
    List<String> opcionais;
    List<String> fotos_url;
}
