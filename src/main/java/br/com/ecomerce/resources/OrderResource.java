package br.com.ecomerce.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecomerce.entities.Order;
import br.com.ecomerce.entities.Order;
import br.com.ecomerce.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){		
		//User u = new User(1L, "Maria", "maria@gmail.com", "9999994434", "123456");	
		List<Order> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	private ResponseEntity<Order> insert(@RequestBody Order entity){	
		
		entity = service.insert(entity);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).body(entity);		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
		obj = service.update(id, obj);	
		return ResponseEntity.ok().body(obj);
	}
	
}
