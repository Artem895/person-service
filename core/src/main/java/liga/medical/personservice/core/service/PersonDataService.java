package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonDataModel;
import liga.medical.personservice.core.repositories.PersonDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDataService {
    private final PersonDataRepo personDataRepo;

    @Autowired
    public PersonDataService(PersonDataRepo personDataRepo) {
        this.personDataRepo = personDataRepo;
    }

    public PersonDataModel findById(Long id){
        return personDataRepo.findById(id).orElse(null);
    }

    public PersonDataModel save(PersonDataModel personDataModel) {
        return personDataRepo.save(personDataModel);
    }
}
