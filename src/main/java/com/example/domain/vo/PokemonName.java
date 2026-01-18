package com.example.domain.vo;

public record PokemonName(String value) {
    public static PokemonName of(String value) {
        return new PokemonName(value);
    }

    public boolean isEmpty() {
        return this.value == null || this.value.trim().isEmpty();
    }
}
