package com.example.gerenciadoratividadefisica.repository;

import com.example.gerenciadoratividadefisica.model.AtividadeFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AtividadeFisicaRepository extends JpaRepository<AtividadeFisica, Long> {
    List<AtividadeFisica> findByUsuarioId(Long usuarioId);
}