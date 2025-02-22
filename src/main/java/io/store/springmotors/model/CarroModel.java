package io.store.springmotors.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.store.springmotors.enums.Cambio;
import io.store.springmotors.enums.Combustivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "tb_carro")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "marca", length = 45, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 45, nullable = false)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "km", nullable = false)
    private Float km;

    @Column(name = "cor", length = 45, nullable = false)
    private String cor;

    @Column(name = "placa", length = 7, nullable = true, unique = true)
    private String placa;

    @Column(name = "preco", nullable = true)
    private BigDecimal preco;

    //@Column(name = "cambio", nullable = false)
    //private String cambio;

    @Column(name = "motor", nullable = false)
    private Float motor;

    //@Column(name = "combustivel", nullable = false)
    //private String combustivel;

    @Enumerated(EnumType.STRING)
    private Cambio cambio;

    @Enumerated(EnumType.STRING)
    private Combustivel combustivel;

    @Column(name = "opcionais", nullable = true)
    private List<String> opcionais;

    @ElementCollection
    @CollectionTable(
            name = "tb_fotos_carro",
            joinColumns = @JoinColumn(name = "foto_id")
    )
    @Column(name = "fotos_url")
    private List<String> fotosUrl;



}
