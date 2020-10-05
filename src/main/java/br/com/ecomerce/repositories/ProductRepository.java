package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
