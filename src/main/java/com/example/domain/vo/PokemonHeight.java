package com.example.domain.vo;

public record PokemonHeight(Double value) {
    public static PokemonHeight of(Double value) {
        return new PokemonHeight(value);
    }

    public boolean isValid() {
        return this.value != null && this.value > 0.0;
    }
}
