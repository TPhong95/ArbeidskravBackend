package org.example.arbeidskravbackend.Manufacturer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.example.arbeidskravbackend.Bicycle.Bicycle;

import java.util.List;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
    @SequenceGenerator(name = "manufacturer_seq", sequenceName = "manufacturer_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany (mappedBy = "manufacturer")
    @JsonIgnoreProperties("manufacturer")
    private List<Bicycle> bicycles;

    public Manufacturer(String email, String phoneNumber, String name, List<Bicycle> bicycles) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.bicycles = bicycles;
    }

    public Manufacturer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
}
