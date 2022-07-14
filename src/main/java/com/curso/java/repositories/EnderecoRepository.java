package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.java.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {

}
