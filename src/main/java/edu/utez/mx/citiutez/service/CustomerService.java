package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Random random = new Random();
        String digits = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Integer.toString(random.nextInt(1 + 10)))
                .collect(Collectors.joining(""));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        customer.setIsactive(true);
        customer.setCard_digits(digits);
        Customer client = customerRespository.save(customer);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(
                employee,
                client,
                "Create",
                client.toString()
                , timestamp, "No hay cambios"));
        digits="";
        return client;
    }

    public Customer update(int id, Customer newCustomer, int idUser) {
        Customer oldCustomer = getOne(id);
        String anterior = oldCustomer.toString();
        String nuevo = newCustomer.getName()
                + " " + newCustomer.getFirstname()
                + " " + newCustomer.getSecondname()
                + " " + newCustomer.getAddress()
                + " " + newCustomer.getPhone()
                + " " + newCustomer.getBirthdate()
                + " "+ newCustomer.getRfc()
                + " " + oldCustomer.getNip()
                + " " + oldCustomer.getCard_digits();

        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setFirstname(newCustomer.getFirstname());
        oldCustomer.setSecondname(newCustomer.getSecondname());
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setPhone(newCustomer.getPhone());
        oldCustomer.setBirthdate(newCustomer.getBirthdate());
        oldCustomer.setRfc(newCustomer.getRfc());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee, oldCustomer, "Update", anterior, timestamp, nuevo));
        return customerRespository.save(oldCustomer);
    }

    public void activate(int id, int idUser) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Customer customer = getOne(id);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee,
                customer, "Update", "Estaba inactivo", timestamp, "Se activó"));
        customer.setIsactive(true);
        customerRespository.save(customer);
    }

    public void delete(int id, int idUser) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Customer customer = getOne(id);
        Employee employee = employeeService.getOne(idUser);
        changeLogsService.save(new ChangeLogs(employee,
                customer, "Delete", "Estaba activo", timestamp, "Se desactivo"));
        customer.setIsactive(false);
        customerRespository.save(customer);
    }
}
