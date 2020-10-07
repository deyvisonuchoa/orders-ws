package br.com.ecomerce.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ecomerce.entities.Category;
import br.com.ecomerce.entities.User;
import br.com.ecomerce.repositories.CategoryRepository;
import br.com.ecomerce.services.exceptions.BusinessException;
import br.com.ecomerce.services.exceptions.DatabaseException;
import br.com.ecomerce.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow( ()-> new ResourceNotFoundException(id) );
	}
	
	public Category insert(Category entity) {
		Category categoriaExistente = repository.findByDescription(entity.getName());
		
		if(categoriaExistente != null && !entity.equals(categoriaExistente)) {
			throw new BusinessException("Category already exists.");
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
	
	public Category update(Long id, Category obj) {
		try {
		Category entity = repository.getOne(id); //get reference
		
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());	
	}
	
}
