package com.example.gerenciadoratividadefisica.service;

import com.example.gerenciadoratividadefisica.dto.AtividadeFisicaDTO;
import com.example.gerenciadoratividadefisica.model.AtividadeFisica;
import com.example.gerenciadoratividadefisica.model.Usuario;
import com.example.gerenciadoratividadefisica.repository.AtividadeFisicaRepository;
import com.example.gerenciadoratividadefisica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtividadeFisicaService {
    
    @Autowired
    private AtividadeFisicaRepository atividadeRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public AtividadeFisica criarAtividade(AtividadeFisicaDTO atividadeDTO) {
        Usuario usuario = usuarioRepository.findById(atividadeDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        AtividadeFisica atividade = new AtividadeFisica();
        atividade.setTipo(atividadeDTO.getTipo());
        atividade.setDataHora(atividadeDTO.getDataHora());
        atividade.setDuracaoMinutos(atividadeDTO.getDuracaoMinutos());
        atividade.setCaloriasQueimadas(atividadeDTO.getCaloriasQueimadas());
        atividade.setUsuario(usuario);
        
        return atividadeRepository.save(atividade);
    }
    
    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
    
    public List<AtividadeFisica> listarAtividadesPorUsuario(Long usuarioId) {
        try {
            return atividadeRepository.findByUsuarioId(usuarioId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar atividades do usuário: " + usuarioId, e);
        }
    }
}