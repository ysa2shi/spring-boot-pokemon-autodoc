package com.example.domain.vo;

public record PokemonWeight(Double value) {
    public static PokemonWeight of(Double value) {
        return new PokemonWeight(value);
    }

    public boolean isValid() {
        return this.value != null && this.value > 0.0;
    }

    public boolean isHeavy() {
        return this.value != null && this.value > 100.0;
    }
}
