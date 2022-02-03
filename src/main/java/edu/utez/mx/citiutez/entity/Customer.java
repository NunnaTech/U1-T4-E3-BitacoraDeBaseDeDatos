package edu.utez.mx.citiutez.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
@Entity
@Table(name="customers")
@Data
public class Customer implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
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

    @OneToMany(mappedBy = "customerlogs")
    @JsonIgnore
    private List<ChangeLogs> customerLogs;

}
