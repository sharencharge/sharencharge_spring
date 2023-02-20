package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.Address;
import fr.ipme.sharencharge.repositories.AddressRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericService<Address> {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        super();
        setRepo(addressRepository);
    }
}
