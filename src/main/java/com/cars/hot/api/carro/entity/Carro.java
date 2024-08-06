package com.cars.hot.api.carro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carro {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String modelo;
    @Column
    private Long serie;
    @Column
    private Long numeroSerie;

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", serie='" + serie + '\'' +
                ", numeroSerie=" + numeroSerie +
                '}';
    }
}
