package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
}
