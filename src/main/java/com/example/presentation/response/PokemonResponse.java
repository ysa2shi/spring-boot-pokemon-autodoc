package com.example.presentation.response;

import com.example.domain.model.Pokemon;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PokemonResponse {
    Integer id;
    String name;
    String genus;
    Double height;
    Double weight;

    public static PokemonResponse from(Pokemon pokemon) {
        return PokemonResponse.builder()
                .id(pokemon.id().value())
                .name(pokemon.name().value())
                .genus(pokemon.genus().value())
                .height(pokemon.height().value())
                .weight(pokemon.weight().value())
                .build();
    }
}