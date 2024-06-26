package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{
private String make;
    private String model;

    private int kilometers;

    private LocalDate registeredOn;

    private Set<Picture> pictures;

    public Car() {
    }
@Column(length = 20)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
@Column(length = 20)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
@Column
    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }
@Column(name = "register_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }
@OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
