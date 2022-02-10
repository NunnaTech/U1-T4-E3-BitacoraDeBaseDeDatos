package edu.utez.mx.citiutez.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="change_logs")
public class ChangeLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    public ChangeLogs() {
    }

    public ChangeLogs(Employee employeelogs, Customer customerlogs, String action, String previous, Timestamp datetime, String next) {
        this.employeelogs = employeelogs;
        this.customerlogs = customerlogs;
        this.action = action;
        this.previous = previous;
        this.datetime = datetime;
        this.next = next;
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

    private String previous;

    private Timestamp datetime;

    private String next;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployeelogs() {
        return employeelogs;
    }

    public void setEmployeelogs(Employee employeelogs) {
        this.employeelogs = employeelogs;
    }

    public Customer getCustomerlogs() {
        return customerlogs;
    }

    public void setCustomerlogs(Customer customerlogs) {
        this.customerlogs = customerlogs;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
