package com.example.domain.vo;

public record PokemonId(Integer value) {
    public static PokemonId of(Integer value) {
        return new PokemonId(value);
    }

    public boolean isValid() {
        return this.value != null && this.value > 0;
    }
}
