package fr.ipme.sharencharge.services;

import com.github.javafaker.Faker;
import fr.ipme.sharencharge.pojos.*;
import fr.ipme.sharencharge.repositories.StationRepository;
import fr.ipme.sharencharge.repositories.UserRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService extends GenericService<User> implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    private StationService stationService;
    private Faker faker;
    private final StationRepository stationRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       StationRepository stationRepository) {
        this.userRepository = userRepository;
        this.faker = new Faker(new Locale("es-ES"));
        setRepo(userRepository);
        this.stationRepository = stationRepository;
    }

    public void generateUser(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = new User();

            user.setFirstname(faker.name().firstName());
            user.setLastname(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setStations(new ArrayList<>());
            user.setAddress(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                Station station = new Station();
                station.setName(faker.funnyName().name());
                station.setUser(user);
                station.setAvailabilities(new ArrayList<>());
                user.getStations().add(station);

                Address address = new Address();
                address.setCity(faker.address().city());
                address.setStreetName(faker.address().streetName());
                address.setStreetNumber(faker.address().streetAddressNumber());
                user.getAddress().add(address);


                for (int k = 0; k < 5; k++) {
                    Availability availability = new Availability();
                    availability.setDuration(faker.number().numberBetween(10,40));
                    availability.setBeginHour(String.valueOf(faker.number().numberBetween(0,12)));
                    availability.setEndHour(String.valueOf(Integer.parseInt(availability.getBeginHour()) + Math.round(Math.random()*3)));
                    availability.setStation(station);
                    station.getAvailabilities().add(availability);
                }
            }
            users.add(user);
        }
        for (User user:
             users) {
            user.setRents(new ArrayList<>());
            for (Station station:
                 user.getStations()) {
                for (Availability availability :
                        station.getAvailabilities()) {
                    Rent rent = new Rent();
                    rent.setUser(users.get((int) Math.round(Math.random()*99)));
                    rent.setAvailabilities(new ArrayList<>());
                    rent.getAvailabilities().add(availability);
                    user.getRents().add(rent);
                }
            }
        }

        userRepository.saveAll(users);
    }
    public List<Station> findStationByUserId(Long id) {
        User user = this.findById(id);
        return this.stationService.findByUser(user);
    }

    public User findOwnerByRentId(Long id) {
        return userRepository.findOwnerById(id);
    }

    public User findByLogin(String login) {
        return userRepository.findByEmail(login);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public boolean existsByEmail(String email) {
       return userRepository.findByEmail(email) != null;
    }
}
