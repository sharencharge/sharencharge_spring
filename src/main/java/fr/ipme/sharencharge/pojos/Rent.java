package fr.ipme.sharencharge.pojos;

import fr.ipme.sharencharge.enumeration.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Rent implements IdentifiablePojo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime byuAt;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    private List<Availability> availabilities;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Rent() {
        this.byuAt = LocalDateTime.now();
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getByuAt() {
        return byuAt;
    }

    public void setByuAt(LocalDateTime byuAt) {
        this.byuAt = byuAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
