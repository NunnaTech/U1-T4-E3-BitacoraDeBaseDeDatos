package edu.utez.mx.citiutez.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
@Entity
@Table(name="session_logs")
@Data
@NoArgsConstructor
public class SessionLogs implements Serializable{

    private static final long serialVersionUID = 1L;

    public SessionLogs(Timestamp datetime, Employee employee) {
        this.datetime = datetime;
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session_logs")
    private Integer id;

    private Timestamp datetime;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
