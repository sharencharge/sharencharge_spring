package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.repositories.StationRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService extends GenericService<Station> {
    private StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository){
        super();
        setRepo(stationRepository);
    }
}
