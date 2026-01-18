package com.example.infrastructure.mapper;

import com.example.domain.vo.PokemonId;
import com.example.infrastructure.entity.PokemonEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PokemonMapper {

    List<PokemonEntity> findAll();

    Optional<PokemonEntity> findById(@Param("id") PokemonId id);
}
