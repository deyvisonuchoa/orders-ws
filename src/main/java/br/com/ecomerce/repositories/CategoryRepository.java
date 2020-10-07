package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ecomerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value = "select * from tb_category obj where obj.name = ?1", nativeQuery = true)
	Category findByDescription(String description);
	
}
