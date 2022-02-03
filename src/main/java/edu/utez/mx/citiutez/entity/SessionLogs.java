package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
@Entity
@Table(name="session_logs")
@Data
public class SessionLogs implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session_logs")
    private Integer id;

    private Timestamp datetime;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}
