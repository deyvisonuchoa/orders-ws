package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
	
}
