package com.cars.hot.api.carro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(modelo, carro.modelo) && Objects.equals(serie, carro.serie) && Objects.equals(numeroSerie, carro.numeroSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, serie, numeroSerie);
    }
}
