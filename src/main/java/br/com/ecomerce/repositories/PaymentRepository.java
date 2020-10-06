package br.com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecomerce.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
