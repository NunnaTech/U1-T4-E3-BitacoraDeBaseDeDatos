package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.respository.CustomerRespository;
import org.hibernate.event.spi.PostInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    public List<Customer> getAll(){
        return (List<Customer>) customerRespository.findAll();
    }

    public Customer getOne(int id){
        return customerRespository.findById(id).get();
    }


    public Customer save(Customer customer){
        return customerRespository.save(customer);
    }

    public Customer update(int id, Customer customer){
        Customer existence = getOne(id);
        existence.setName(customer.getName());
        existence.setFirstname(customer.getFirstname());
        existence.setSecondname(customer.getSecondname());
        existence.setAddress(customer.getAddress());
        existence.setPhone(customer.getPhone());
        existence.setBirthdate(customer.getBirthdate());
        existence.setRfc(customer.getRfc());
        return customerRespository.save(existence);
    }
    public void delete(int id){
        customerRespository.deleteById(id);
    }
}
