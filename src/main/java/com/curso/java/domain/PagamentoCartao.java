package com.curso.java.domain;

import javax.persistence.Entity;

import com.curso.java.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	public PagamentoCartao() {
		
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas ) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;

	}

	private Integer numeroParcelas;

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
}

