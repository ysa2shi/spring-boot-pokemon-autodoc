package com.example.controller;

import com.example.usecase.ViewPokemonAllUseCase;
import com.example.controller.resource.PokemonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Pokemon", description = "ポケモン情報管理")
public class PokemonController {

    private final ViewPokemonAllUseCase viewPokemonAllUseCase;

    @GetMapping("/v1/pokemons")
    @Operation(
        summary = "全件取得",
        description = "図鑑から全ポケモンを取得します。",
        responses = {
            @ApiResponse(responseCode = "200", description = "ポケモン情報一覧",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(type = "array", implementation = PokemonResponse.class)))
            }
    )
    public List<PokemonResponse> allPokemon() {
        return viewPokemonAllUseCase.execute();
    }
}