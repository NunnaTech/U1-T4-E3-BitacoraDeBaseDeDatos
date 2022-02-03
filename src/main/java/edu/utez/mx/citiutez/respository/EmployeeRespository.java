package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.entity.SessionLogs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends CrudRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM employees WHERE email = :email", nativeQuery = true)
    Employee getByEmail(@Param(value="email") String email);
}
