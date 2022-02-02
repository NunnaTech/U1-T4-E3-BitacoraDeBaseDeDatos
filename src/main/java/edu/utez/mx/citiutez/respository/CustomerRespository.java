package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends CrudRepository<Customer,Integer> {
}
