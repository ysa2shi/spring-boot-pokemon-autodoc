package com.example.presentation;

import com.example.application.ViewPokemonAllUseCase;
import com.example.domain.model.Pokemon;
import com.example.presentation.response.PokemonResponse;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "全件取得", description = "図鑑から全ポケモンを取得します。")
    public List<PokemonResponse> allPokemon() {
        return viewPokemonAllUseCase.execute();
    }
}