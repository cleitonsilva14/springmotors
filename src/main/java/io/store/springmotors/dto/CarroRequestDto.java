package io.store.springmotors.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class CarroRequestDto{

        @NotBlank(message = "marca não pode estar em branco")
        String marca;

        @NotBlank(message = "modelo não pode estar em branco")
        String modelo;

        @PositiveOrZero
        @NotNull(message = "ano não pode ser null")
        int ano;

        @PositiveOrZero
        double km;

        @NotBlank(message = "cor deve ser informada")
        String cor;

        @NotBlank(message = "placa deve ser informada")
        String placa;

        @PositiveOrZero(message = "preço deve ser 0 ou positivo ")
        BigDecimal preco;

        @NotNull(message = "motor não pode ser null")
        Float motor;

        @NotBlank(message = "câmbio deve ser informado")
        String cambio;

        @NotBlank(message = "combustível deve ser informado")
        String combustivel;

        List<String> opcionais;

        List<String> fotos_url;

}