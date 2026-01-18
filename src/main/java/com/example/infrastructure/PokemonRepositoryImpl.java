package com.example.infrastructure;

import com.example.domain.model.Pokemon;
import com.example.domain.model.PokemonFactory;
import com.example.domain.repository.PokemonRepository;
import com.example.domain.vo.PokemonId;
import com.example.infrastructure.mapper.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonMapper pokemonMapper;
    private final PokemonFactory pokemonFactory;

    @Override
    public List<Pokemon> findAll() {

        return pokemonMapper.findAll().stream()
                .map(entity -> pokemonFactory.create(
                        entity.getId(), entity.getName(), entity.getGenus(),
                        entity.getHeight(), entity.getWeight()
                ))
                .toList();
    }

    @Override
    public Pokemon findById(PokemonId id) {
        return null;
    }
}