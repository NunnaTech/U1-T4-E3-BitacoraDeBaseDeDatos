package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="customers")
@Data
public class Customer {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String firstname;

    private String secondname;

    private String address;

    private String phone;

    private Date birthdate;

    private String rfc;

    private String nip;

    private boolean cardtype;

    private String card_digits;

    @OneToMany(mappedBy = "customerLogs")
    private List<ChangeLogs> customerLogs;

}
