package com.example.domain.repository;

import com.example.domain.model.Pokemon;
import com.example.domain.vo.PokemonId;

import java.util.List;

public interface PokemonRepository {
    List<Pokemon> findAll();
    Pokemon findById(PokemonId id);
}
