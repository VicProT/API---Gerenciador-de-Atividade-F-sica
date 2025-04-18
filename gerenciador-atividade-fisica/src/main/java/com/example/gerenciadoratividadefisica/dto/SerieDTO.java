package com.example.gerenciadoratividadefisica.dto;

import lombok.Data;

@Data
public class SerieDTO {
    private String exercicio;
    private Integer repeticoes;
    private Double peso;
    private String observacoes;
    private Long atividadeId;
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public Integer getRepeticoes() {
		return repeticoes;
	}
	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Long getAtividadeId() {
		return atividadeId;
	}
	public void setAtividadeId(Long atividadeId) {
		this.atividadeId = atividadeId;
	}
    
    
}