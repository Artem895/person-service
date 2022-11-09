package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.AddressModel;
import liga.medical.personservice.core.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public AddressModel findById(long id) {
        return addressRepo.findById(id).orElse(null);
    }

    public AddressModel save(AddressModel addressModel) {
        return addressRepo.save(addressModel);
    }
}
