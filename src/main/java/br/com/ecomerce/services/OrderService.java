package br.com.ecomerce.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ecomerce.entities.Order;
import br.com.ecomerce.entities.Order;
import br.com.ecomerce.entities.User;
import br.com.ecomerce.repositories.OrderRepository;
import br.com.ecomerce.services.exceptions.BusinessException;
import br.com.ecomerce.services.exceptions.DatabaseException;
import br.com.ecomerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = repository.findById(id);
		return order.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public Order insert(Order entity) {		
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
	
	public Order update(Long id, Order obj) {
		try {
		Order entity = repository.getOne(id); //get reference
		
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order entity, Order obj) {
		entity.setMoment(obj.getMoment());
		entity.setStatus(obj.getStatus());
		entity.setUser(obj.getUser());
		entity.setPayment(obj.getPayment());
	}
}
