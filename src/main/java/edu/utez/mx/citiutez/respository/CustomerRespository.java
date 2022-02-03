package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespository extends CrudRepository<Customer,Integer> {
    @Query(value = "select e.name, e.firstname, e.secondname, e.rfc from customers e", nativeQuery = true)
    List<Customer> getAllCustomers();
}
