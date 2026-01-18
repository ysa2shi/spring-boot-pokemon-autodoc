package com.example.domain.model;

import com.example.domain.vo.*;
import lombok.Builder;

@Builder
public record Pokemon(
        PokemonId id,
        PokemonName name,
        PokemonGenus genus,
        PokemonHeight height,
        PokemonWeight weight) {
    public boolean isHeavy() {
        return this.weight.isHeavy();
    }
}
