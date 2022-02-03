package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="change_logs")
@Data
public class ChangeLogs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="id")
    private Customer customer;


}
