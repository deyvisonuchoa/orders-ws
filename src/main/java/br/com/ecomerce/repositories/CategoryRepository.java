package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
