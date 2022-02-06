package edu.utez.mx.citiutez.service;

import edu.utez.mx.citiutez.entity.ChangeLogs;
import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.entity.SessionLogs;
import edu.utez.mx.citiutez.respository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRespository employeeRespository;

    @Autowired
    private SessionLogsService sessionLogsService;

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

    public Map<String, Object> checkUser(Employee login){
        Map<String, Object> map = new HashMap<String, Object>();
        Employee session = getByEmail(login.getEmail());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SessionLogs logs = new SessionLogs();
        if (session==null){
            map.put("noUser","true");
        }else{
            if (login.getPassword().equals(session.getPassword())){
                if (!session.isIsadmin()){
                    map.put("noUser","false");
                    map.put("isAdmin","false");
                    map.put("idUser",session.getId());
                    logs.setDatetime(timestamp);
                    logs.setEmployee(session);
                    saveSessionLogs(logs);
                }else {
                    map.put("noUser","false");
                    map.put("isAdmin","true");
                    map.put("idUser",session.getId());
                    logs.setDatetime(timestamp);
                    logs.setEmployee(session);
                    saveSessionLogs(logs);
                }
            }else{
                map.put("noUser","true");
            }
        }
        return map;
    }

    public void saveSessionLogs(SessionLogs logs){
        sessionLogsService.save(logs);
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

    public void activate(int id){
        Employee employee = getOne(id);
        employee.setIsactive(false);
        employeeRespository.save(employee);
    }

    public void delete(int id){
        Employee employee = getOne(id);
        employee.setIsactive(true);
        employeeRespository.save(employee);
    }

}
