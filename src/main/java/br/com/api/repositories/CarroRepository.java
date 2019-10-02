package br.com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.models.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

	
}
