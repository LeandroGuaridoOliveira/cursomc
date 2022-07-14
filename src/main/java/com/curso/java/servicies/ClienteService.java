package com.curso.java.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.curso.java.repositories.ClienteRepository;
import com.curso.java.servicies.exceptions.ObjectNotFoundExecption;
import com.curso.java.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		 if(obj == null) {
			 throw new ObjectNotFoundExecption("Objeto nao encontrado. id: " + id
		+ ", Tipo: " + Cliente.class.getName());			 
		 }
		return obj.orElse(null);
		} 



	
}
