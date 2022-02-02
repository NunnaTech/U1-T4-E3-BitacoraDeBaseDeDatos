package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import edu.utez.mx.citiutez.entity.SessionLogs;
import edu.utez.mx.citiutez.respository.SessionLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionLogsService {

    @Autowired
    private SessionLogsRepository sessionLogsRepository;

    public List<SessionLogs> getAll(){
        return (List<SessionLogs>) sessionLogsRepository.findAll();
    }

    public SessionLogs getOne(int id){
        return sessionLogsRepository.findById(id).get();
    }

    public SessionLogs save(SessionLogs sessionLogs){
        return sessionLogsRepository.save(sessionLogs);
    }
}
