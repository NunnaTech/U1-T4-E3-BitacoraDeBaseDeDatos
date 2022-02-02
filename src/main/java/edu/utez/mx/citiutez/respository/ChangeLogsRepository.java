package edu.utez.mx.citiutez.respository;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeLogsRepository extends CrudRepository<ChangeLogs,Integer> {
}
