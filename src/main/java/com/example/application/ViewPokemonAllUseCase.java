package com.example.application;

import com.example.domain.repository.PokemonRepository;
import com.example.presentation.response.PokemonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewPokemonAllUseCase {

    private final PokemonRepository pokemonRepository;

    /**
     * ポケモン一覧を取得するユースケース
     */
    @Transactional(readOnly = true)
    public List<PokemonResponse> execute() {
        return pokemonRepository.findAll().stream()
                .map(PokemonResponse::from)
                .toList();
    }
}