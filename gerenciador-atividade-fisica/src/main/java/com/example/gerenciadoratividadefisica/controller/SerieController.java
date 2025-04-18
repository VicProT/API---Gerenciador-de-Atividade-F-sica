package com.example.gerenciadoratividadefisica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadoratividadefisica.dto.SerieDTO;
import com.example.gerenciadoratividadefisica.model.Serie;
import com.example.gerenciadoratividadefisica.service.SerieService;

@RestController
@RequestMapping("/api/series")
public class SerieController {
    
    @Autowired
    private SerieService serieService;
    
    @PostMapping
    public ResponseEntity<?> criarSerie(@RequestBody SerieDTO serieDTO) {
        try {
            Serie serie = serieService.criarSerie(serieDTO);
            return ResponseEntity.ok(serie);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/atividade/{atividadeId}")
    public ResponseEntity<List<Serie>> listarSeriesPorAtividade(@PathVariable Long atividadeId) {
        List<Serie> series = serieService.listarSeriesPorAtividade(atividadeId);
        return ResponseEntity.ok(series);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSerie(@PathVariable Long id) {
        try {
            serieService.deletarSerie(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }
}