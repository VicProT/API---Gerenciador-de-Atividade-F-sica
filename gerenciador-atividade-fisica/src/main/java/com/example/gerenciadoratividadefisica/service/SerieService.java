package com.example.gerenciadoratividadefisica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadoratividadefisica.dto.SerieDTO;
import com.example.gerenciadoratividadefisica.model.AtividadeFisica;
import com.example.gerenciadoratividadefisica.model.Serie;
import com.example.gerenciadoratividadefisica.repository.AtividadeFisicaRepository;
import com.example.gerenciadoratividadefisica.repository.SerieRepository;

@Service
public class SerieService {
    
    @Autowired
    private SerieRepository serieRepository;
    
    @Autowired
    private AtividadeFisicaRepository atividadeRepository;
    
    public Serie criarSerie(SerieDTO serieDTO) {
        AtividadeFisica atividade = atividadeRepository.findById(serieDTO.getAtividadeId())
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        
        // Validação: só permite peso e repetições se for Musculação
        if (!"Musculação".equalsIgnoreCase(atividade.getTipo())) {
            if (serieDTO.getPeso() != null || serieDTO.getRepeticoes() != null) {
                throw new RuntimeException("Peso e repetições só são permitidos para atividades do tipo 'Musculação'");
            }
        }
        
        Serie serie = new Serie();
        serie.setExercicio(serieDTO.getExercicio());
        serie.setRepeticoes(serieDTO.getRepeticoes());
        serie.setPeso(serieDTO.getPeso());
        serie.setObservacoes(serieDTO.getObservacoes());
        serie.setAtividade(atividade);
        
        return serieRepository.save(serie);
    }
    
    public List<Serie> listarSeriesPorAtividade(Long atividadeId) {
        return serieRepository.findByAtividadeId(atividadeId);
    }
    
    public void deletarSerie(Long id) {
        serieRepository.deleteById(id);
    }
}