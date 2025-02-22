package io.store.springmotors.dto;


import io.store.springmotors.enums.Cambio;
import io.store.springmotors.enums.Combustivel;
import jakarta.validation.constraints.*;
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

        @Pattern(regexp = "^[A-Z]{3}[0-9]{1}[A-J]{1}[0-9]{2}$", message = "placa informada está fora do padrão Mercosul")
        @NotBlank(message = "placa deve ser informada")
        String placa;

        @PositiveOrZero(message = "preço deve ser 0 ou positivo ")
        BigDecimal preco;

        @NotNull(message = "motor não pode ser null")
        Float motor;

        //@NotBlank(message = "câmbio deve ser informado")
        Cambio cambio;

        //@NotBlank(message = "combustível deve ser informado")
        Combustivel combustivel;

        List<String> opcionais;

        List<String> fotosUrl;

}