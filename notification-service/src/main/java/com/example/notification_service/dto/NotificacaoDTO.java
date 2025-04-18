package com.example.notification_service.dto;

public class NotificacaoDTO {
    private Long usuarioId;
    private String mensagem;

    // Getters e Setters
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}