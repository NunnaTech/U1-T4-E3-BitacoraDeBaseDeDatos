package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="change_logs")
@Data
public class ChangeLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_change_logs")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employeeLogs;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customerLogs;

}
