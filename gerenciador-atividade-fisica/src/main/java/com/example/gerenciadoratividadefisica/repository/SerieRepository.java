package com.example.gerenciadoratividadefisica.repository;

import com.example.gerenciadoratividadefisica.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findByAtividadeId(Long atividadeId);
}