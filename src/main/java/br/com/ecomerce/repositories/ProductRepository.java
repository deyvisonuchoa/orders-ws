package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ecomerce.entities.Category;
import br.com.ecomerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "select * from tb_product obj where obj.name = ?1", nativeQuery = true)
	Product findByName(String name);
	
}
