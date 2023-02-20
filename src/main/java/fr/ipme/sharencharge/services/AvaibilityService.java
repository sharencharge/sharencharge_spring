package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.Availability;
import fr.ipme.sharencharge.repositories.AvaibilityRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaibilityService extends GenericService<Availability> {
    private AvaibilityRepository avaibilityRepository;

    @Autowired
    public AvaibilityService(AvaibilityRepository avaibilityRepository){
        super();
        setRepo(avaibilityRepository);
    }
}
