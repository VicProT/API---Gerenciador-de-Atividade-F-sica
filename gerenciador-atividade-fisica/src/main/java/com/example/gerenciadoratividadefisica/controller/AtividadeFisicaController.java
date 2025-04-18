package com.example.gerenciadoratividadefisica.controller;

import com.example.gerenciadoratividadefisica.dto.AtividadeFisicaDTO;
import com.example.gerenciadoratividadefisica.model.AtividadeFisica;
import com.example.gerenciadoratividadefisica.service.AtividadeFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeFisicaController {
    
    @Autowired
    private AtividadeFisicaService atividadeService;
    
    @PostMapping
    public ResponseEntity<AtividadeFisica> criarAtividade(@RequestBody AtividadeFisicaDTO atividadeDTO) {
        AtividadeFisica atividade = atividadeService.criarAtividade(atividadeDTO);
        return ResponseEntity.ok(atividade);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AtividadeFisica>> listarAtividadesPorUsuario(
            @PathVariable Long usuarioId) {
        try {
            List<AtividadeFisica> atividades = atividadeService.listarAtividadesPorUsuario(usuarioId);
            return ResponseEntity.ok(atividades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}