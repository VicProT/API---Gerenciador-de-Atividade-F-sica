package com.example.notification_service.controller;

import com.example.notification_service.dto.NotificacaoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @PostMapping
    public String receberNotificacao(@RequestBody NotificacaoDTO notificacao) {
        System.out.println("[NOTIFICAÇÃO] Usuário " + notificacao.getUsuarioId() + 
                         ": " + notificacao.getMensagem());
        return "Notificação recebida com sucesso";
    }
}