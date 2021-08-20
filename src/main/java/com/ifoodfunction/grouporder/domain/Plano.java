package com.ifoodfunction.grouporder.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plano implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private String descricao;
	private String porcentagemCobrada;
	private Double mensalidade;

	public Plano () {
		
	}		
	
	public Plano(Integer id, String tipo, String descricao, String porcentagemCobrada, Double mensalidade) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.porcentagemCobrada = porcentagemCobrada;
		this.mensalidade = mensalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getporcentagemCobrada() {
		return porcentagemCobrada;
	}

	public void setporcentagemCobrada(String porcentagemCobrada) {
		this.porcentagemCobrada = porcentagemCobrada;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plano other = (Plano) obj;
		return Objects.equals(id, other.id);
	}
	
}
