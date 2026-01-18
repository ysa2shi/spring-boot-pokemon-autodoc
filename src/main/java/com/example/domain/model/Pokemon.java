package com.example.domain.model;

import com.example.domain.vo.PokemonId;
import com.example.domain.vo.PokemonName;
import com.example.domain.vo.PokemonGenus;
import com.example.domain.vo.PokemonHeight;
import com.example.domain.vo.PokemonWeight;
import lombok.Builder;
import lombok.Data;

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
