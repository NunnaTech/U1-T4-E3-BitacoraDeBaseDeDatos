package edu.utez.mx.citiutez.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name="employees")
@Data
public class Employee implements  Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;

    private String name;

    private String firstname;

    private String secondname;

    private String address;

    private String phone;

    private String birthdate;

    private String email;

    private String password;

    private boolean isadmin;

    private boolean isactive;

    @JsonIgnore
    @OneToMany (mappedBy = "employee")
    private List<SessionLogs> sessions;

    @OneToMany(mappedBy = "employeelogs")
    @JsonIgnore
    private List<ChangeLogs> changeLogs;

}
