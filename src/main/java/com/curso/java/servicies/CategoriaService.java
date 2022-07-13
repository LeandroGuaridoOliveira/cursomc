package com.curso.java.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.curso.java.repositories.CategoriaRepository;
import com.curso.java.servicies.exceptions.ObjectNotFoundExecption;
import com.curso.java.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		 if(obj == null) {
			 throw new ObjectNotFoundExecption("Objeto nao encontrado. id: " + id
		+ ", Tipo: " + Categoria.class.getName());			 
		 }
		return obj.orElse(null);
		} 



	
}
