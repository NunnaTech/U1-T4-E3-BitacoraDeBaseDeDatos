package edu.utez.mx.citiutez.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name="employees")
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

    public Employee() {
    }

    public Employee(String name, String firstname, String secondname, String address, String phone, String birthdate, String email, String password, boolean isadmin, boolean isactive, List<SessionLogs> sessions, List<ChangeLogs> changeLogs) {
        this.name = name;
        this.firstname = firstname;
        this.secondname = secondname;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.isadmin = isadmin;
        this.isactive = isactive;
        this.sessions = sessions;
        this.changeLogs = changeLogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public List<SessionLogs> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionLogs> sessions) {
        this.sessions = sessions;
    }

    public List<ChangeLogs> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<ChangeLogs> changeLogs) {
        this.changeLogs = changeLogs;
    }
}
