package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;
    @Autowired
    private ChangeLogsService changeLogsService;
    @Autowired
    private EmployeeService employeeService;


    public List<Customer> getAll() {
        return (List<Customer>) customerRespository.findAll();
    }

    public Customer getOne(int id) {
        return customerRespository.findById(id).get();
    }


    public Customer save(Customer customer, int idUser) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        customer.setIsactive(true);
        Customer client = customerRespository.save(customer);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(
                employee,
                client,
                "Create",
                "Se inserto al cliente con RFC: " + client.getRfc()
                , timestamp));
        return client;
    }

    public Customer update(int id, Customer customer, int idUser) {
        Customer existence = getOne(id);
        existence.setName(customer.getName());
        existence.setFirstname(customer.getFirstname());
        existence.setSecondname(customer.getSecondname());
        existence.setAddress(customer.getAddress());
        existence.setPhone(customer.getPhone());
        existence.setBirthdate(customer.getBirthdate());
        existence.setRfc(customer.getRfc());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee, existence, "Update", "Se actualizo al cliente con RFC: " + existence.getRfc(), timestamp));
        return customerRespository.save(existence);
    }

    public void activate(int id, int idUser){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Customer customer = getOne(id);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee,
                customer, "Update", "Se reactivo al cliente con RFC: " + customer.getRfc(), timestamp));
        customer.setIsactive(false);
        customerRespository.save(customer);
    }

    public void delete(int id, int idUser) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Customer customer = getOne(id);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee,
                customer, "Delete", "Se elimino al cliente con RFC: " + customer.getRfc(), timestamp));
        customer.setIsactive(true);
        customerRespository.save(customer);
    }
}
