package br.com.ecomerce.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ecomerce.entities.Category;
import br.com.ecomerce.entities.Product;
import br.com.ecomerce.repositories.ProductRepository;
import br.com.ecomerce.services.exceptions.BusinessException;
import br.com.ecomerce.services.exceptions.DatabaseException;
import br.com.ecomerce.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public Product insert(Product entity) {
		Product objExistente = repository.findByName(entity.getName());
		
		if(objExistente != null && !entity.equals(objExistente)) {
			throw new BusinessException("Product already exists.");
		}	
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		try {
		Product entity = repository.getOne(id); //get reference
		
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());	
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
		obj.getCategories().forEach( (category) -> {
			if(!entity.getCategories().contains(category)) {
				entity.getCategories().add(category);
			}
		}) ;
	}
	
}
