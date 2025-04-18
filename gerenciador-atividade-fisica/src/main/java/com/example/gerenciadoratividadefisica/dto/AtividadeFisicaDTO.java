package com.example.gerenciadoratividadefisica.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AtividadeFisicaDTO {
	
    private String tipo;
    private LocalDateTime dataHora;
    private Integer duracaoMinutos;
    private Integer caloriasQueimadas;
    private Long usuarioId;
    
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	public Integer getCaloriasQueimadas() {
		return caloriasQueimadas;
	}
	public void setCaloriasQueimadas(Integer caloriasQueimadas) {
		this.caloriasQueimadas = caloriasQueimadas;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
    
}