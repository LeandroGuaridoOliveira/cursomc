package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.java.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer> {

}
