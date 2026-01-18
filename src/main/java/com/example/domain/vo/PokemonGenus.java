package com.example.domain.vo;

public record PokemonGenus(String value) {
    public static PokemonGenus of(String value) {
        return new PokemonGenus(value);
    }

    public boolean isEmpty() {
        return this.value == null || this.value.trim().isEmpty();
    }
}
