package com.example.gerenciadoratividadefisica.controller;

import com.example.gerenciadoratividadefisica.dto.LoginDTO;
import com.example.gerenciadoratividadefisica.dto.UsuarioDTO;
import com.example.gerenciadoratividadefisica.model.Usuario;
import com.example.gerenciadoratividadefisica.repository.UsuarioRepository;
import com.example.gerenciadoratividadefisica.service.UsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(loginDTO.getEmail());
        
        if (usuarioOptional.isPresent() && usuarioOptional.get().getSenha().equals(loginDTO.getSenha())) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Long id, 
            @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
    
    @GetMapping("/usuario-logado")
    public ResponseEntity<Usuario> getUsuarioLogado(@RequestParam String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        return usuarioOptional.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }
}