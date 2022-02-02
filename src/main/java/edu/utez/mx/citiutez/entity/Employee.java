package edu.utez.mx.citiutez.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="employees")
@Data
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String firstname;

    private String secondname;

    private String address;

    private String phone;

    private Date birthdate;

    private String email;

    private String password;

    private boolean isadmin;

    @OneToMany (mappedBy = "employee")
    private List<SessionLogs> sessions;

    @OneToMany(mappedBy = "employeeLogs")
    private List<ChangeLogs> changeLogsEmployee;

}
