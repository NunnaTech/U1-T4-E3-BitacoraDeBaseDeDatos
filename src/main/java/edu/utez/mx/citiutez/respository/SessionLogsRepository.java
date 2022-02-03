package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.SessionLogs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionLogsRepository extends CrudRepository<SessionLogs,Integer> {
    @Query(value = "select e.name, e.email, e.firstname, e.phone, datetime from session_logs join employees e on e.id_employee=employee_id", nativeQuery = true)
    List<SessionLogs> getAllSessions();
}
