package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.SessionLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLogsRepository extends CrudRepository<SessionLogs,Integer> {
}
