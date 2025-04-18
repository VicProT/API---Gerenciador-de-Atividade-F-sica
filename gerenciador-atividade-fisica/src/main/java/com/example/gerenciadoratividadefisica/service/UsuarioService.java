package com.example.gerenciadoratividadefisica.service;

import com.example.gerenciadoratividadefisica.dto.UsuarioDTO;
import com.example.gerenciadoratividadefisica.model.Usuario;
import com.example.gerenciadoratividadefisica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha()); // Na prática, deve ser criptografada
        usuario.setNome(usuarioDTO.getNome());
        usuario.setPeso(usuarioDTO.getPeso());
        usuario.setAltura(usuarioDTO.getAltura());
        usuario.setIdade(usuarioDTO.getIdade());
        
        return usuarioRepository.save(usuario);
    }
    
    public Usuario atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        
        if(usuarioDTO.getNome() != null) usuario.setNome(usuarioDTO.getNome());
        if(usuarioDTO.getPeso() != null) usuario.setPeso(usuarioDTO.getPeso());
        if(usuarioDTO.getAltura() != null) usuario.setAltura(usuarioDTO.getAltura());
        if(usuarioDTO.getIdade() != null) usuario.setIdade(usuarioDTO.getIdade());
        
        return usuarioRepository.save(usuario);
    }
    
    public boolean login(String email, String senha) {
        return usuarioRepository.findByEmail(email)
                .map(u -> u.getSenha().equals(senha))
                .orElse(false);
    }
}