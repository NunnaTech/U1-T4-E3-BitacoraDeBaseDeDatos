package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.respository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRespository employeeRespository;

    public List<Employee> getAll(){
        return (List<Employee>) employeeRespository.findAll();
    }

    public Employee getOne(int id){
        return employeeRespository.findById(id).get();
    }

    public Employee getByEmail(String email){
        return employeeRespository.getByEmail(email);
    }

    public Employee save(Employee employee){
         return employeeRespository.save(employee);
    }

    public Employee update(int id, Employee employee){
        Employee existence = getOne(id);
        existence.setName(employee.getName());
        existence.setFirstname(employee.getFirstname());
        existence.setSecondname(employee.getSecondname());
        existence.setAddress(employee.getAddress());
        existence.setPhone(employee.getPhone());
        existence.setBirthdate(employee.getBirthdate());
        existence.setEmail(employee.getEmail());
        existence.setPassword(employee.getPassword());
        return employeeRespository.save(existence);
    }

    public void delete(int id){
        employeeRespository.deleteById(id);
    }

}
