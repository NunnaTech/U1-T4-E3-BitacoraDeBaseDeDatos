package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends CrudRepository<Employee,Integer> {
}
