package com.javanauta.usuario.infrastructure.repository;

import com.brunorafaeldev.trabalhandospring.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRespository extends JpaRepository<Endereco, Long> {
}
