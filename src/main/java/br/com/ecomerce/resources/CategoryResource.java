package br.com.ecomerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecomerce.entities.Category;
import br.com.ecomerce.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	private ResponseEntity<List<Category>> findAll(){
		
		List<Category> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
