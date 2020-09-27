package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
