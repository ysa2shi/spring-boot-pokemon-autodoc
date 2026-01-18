package com.example.domain.model;

import com.example.domain.vo.*;
import org.springframework.stereotype.Component;

@Component
public class PokemonFactory {
    public Pokemon create(Integer id, String name, String genus, Double height, Double weight) {
        return Pokemon.builder()
                .id(PokemonId.of(id))          // static factory method を使用
                .name(PokemonName.of(name))
                .genus(PokemonGenus.of(genus))
                .height(PokemonHeight.of(height))
                .weight(PokemonWeight.of(weight))
                .build();
    }
}