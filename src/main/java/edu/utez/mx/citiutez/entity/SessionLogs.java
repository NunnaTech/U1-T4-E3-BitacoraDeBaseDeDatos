package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="session_logs")
@Data
public class SessionLogs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp datetime;

    @ManyToOne
    @JoinColumn(name="id")
    private Employee employee;
}
