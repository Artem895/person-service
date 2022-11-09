package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.ContactModel;
import liga.medical.personservice.core.repositories.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public ContactModel findById(long id) {
        return contactRepo.findById(id).orElse(null);
    }

    public ContactModel save(ContactModel contactModel) {
        return contactRepo.save(contactModel);
    }
}
