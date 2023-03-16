package fr.ipme.sharencharge.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.ipme.sharencharge.serializer.CustomAvailibilitySerializer;
import fr.ipme.sharencharge.serializer.CustomStationASerializer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Availability implements IdentifiablePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String beginHour;
    private String endHour;
    private String weekDay;
    private Integer duration;
    private Float price;
    @ManyToOne
    @JsonSerialize(using = CustomStationASerializer.class)
    @JoinColumn(name = "station_id")
    private Station station;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rents;

    public Availability() {
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
