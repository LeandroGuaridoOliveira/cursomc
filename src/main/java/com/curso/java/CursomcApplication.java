package com.curso.java;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.java.domain.Categoria;
import com.curso.java.domain.Cidade;
import com.curso.java.domain.Cliente;
import com.curso.java.domain.Endereco;
import com.curso.java.domain.Estado;
import com.curso.java.domain.Produto;
import com.curso.java.domain.enums.TipoCliente;
import com.curso.java.repositories.CategoriaRepository;
import com.curso.java.repositories.CidadeRepository;
import com.curso.java.repositories.ClienteRepository;
import com.curso.java.repositories.EnderecoRepository;
import com.curso.java.repositories.EstadoRepository;
import com.curso.java.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList( p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1)); 

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null,"Maria Silva" , "maria@gmail.com", "123456789013", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("12345678", "87654321"));
		
		Endereco e1 = new Endereco(null,"Rua flores","300","Apto 303","Jardins","97865432", cli1, c1);
		Endereco e2 = new Endereco(null,"Avenida seixas","120","sala 300","Centro","37914862", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}

