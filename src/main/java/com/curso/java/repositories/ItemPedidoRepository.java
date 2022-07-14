package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.java.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer> {

}
