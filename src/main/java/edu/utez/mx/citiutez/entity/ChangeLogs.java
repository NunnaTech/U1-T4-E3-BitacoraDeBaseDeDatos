package edu.utez.mx.citiutez.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="change_logs")
@Data
@NoArgsConstructor
public class ChangeLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    public ChangeLogs(Employee employeelogs, Customer customerlogs, String action, String information, Timestamp datetime) {
        this.employeelogs = employeelogs;
        this.customerlogs = customerlogs;
        this.action = action;
        this.information = information;
        this.datetime = datetime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_change_logs")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employeelogs;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customerlogs;

    private String action;

    private String information;

    private Timestamp datetime;

}
