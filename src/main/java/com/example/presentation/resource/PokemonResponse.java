package com.example.presentation.resource;

import com.example.domain.model.Pokemon;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ポケモン情報レスポンス")
public record PokemonResponse(
        @Schema(description = "ポケモンID", example = "1") Integer id,
        @Schema(description = "ポケモン名", example = "フシギダネ") String name,
        @Schema(description = "ポケモンの分類", example = "たねポケモン") String genus,
        @Schema(description = "ポケモンの高さ(m)", example = "0.71") Double height,
        @Schema(description = "ポケモンの重さ(kg)", example = "6.9") Double weight
) {
    public static PokemonResponse from(Pokemon pokemon) {
        return new PokemonResponse(
                pokemon.id().value(),
                pokemon.name().value(),
                pokemon.genus().value(),
                pokemon.height().value(),
                pokemon.weight().value()
        );
    }
}