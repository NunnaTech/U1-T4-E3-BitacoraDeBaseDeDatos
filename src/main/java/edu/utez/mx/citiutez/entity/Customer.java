package edu.utez.mx.citiutez.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
@Entity
@Table(name="customers")
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

    private String birthdate;

    private String rfc;

    private String nip;

    private boolean cardtype;

    private String card_digits;

    private boolean isactive;

    @OneToMany(mappedBy = "customerlogs")
    @JsonIgnore
    private List<ChangeLogs> customerlogs;

    public Customer() {
    }

    public Customer(String name, String firstname, String secondname, String address, String phone, String birthdate, String rfc, String nip, boolean cardtype, String card_digits, boolean isactive, List<ChangeLogs> customerlogs) {
        this.name = name;
        this.firstname = firstname;
        this.secondname = secondname;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
        this.rfc = rfc;
        this.nip = nip;
        this.cardtype = cardtype;
        this.card_digits = card_digits;
        this.isactive = isactive;
        this.customerlogs = customerlogs;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public boolean isCardtype() {
        return cardtype;
    }

    public void setCardtype(boolean cardtype) {
        this.cardtype = cardtype;
    }

    public String getCard_digits() {
        return card_digits;
    }

    public void setCard_digits(String card_digits) {
        this.card_digits = card_digits;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public List<ChangeLogs> getCustomerlogs() {
        return customerlogs;
    }

    public void setCustomerlogs(List<ChangeLogs> customerlogs) {
        this.customerlogs = customerlogs;
    }

    @Override
    public String toString() {
        return  " "  +
                " " + name  +
                " " + firstname +
                " " + secondname +
                " " + address  +
                " " + phone +
                " " + birthdate +
                " " + rfc +
                " " + nip +
                " " + card_digits;
    }
}
