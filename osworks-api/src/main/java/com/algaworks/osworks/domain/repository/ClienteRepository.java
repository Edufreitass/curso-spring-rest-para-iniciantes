package com.algaworks.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

//	List<Cliente> findByNome(String nome);

	// query que procura pela letra ou parte de algum nome
//	List<Cliente> findByNomeContaining(String nome);

	Cliente findByEmail(String email);

}
