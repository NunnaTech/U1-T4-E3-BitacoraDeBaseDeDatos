package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.respository.ChangeLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeLogsService {

    @Autowired
    private ChangeLogsRepository changeLogsRepository;

    public List<ChangeLogs> getAll(){
        return (List<ChangeLogs>) changeLogsRepository.findAll();
    }

    public ChangeLogs getOne(int id){
        return changeLogsRepository.findById(id).get();
    }

    public ChangeLogs save(ChangeLogs changeLogs){
        return changeLogsRepository.save(changeLogs);
    }

}
