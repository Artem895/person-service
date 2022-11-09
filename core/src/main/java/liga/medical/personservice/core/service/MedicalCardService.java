package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MecalCardModel;
import liga.medical.personservice.core.repositories.MedicalCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalCardService {
    private final MedicalCardRepo medicalCardRepo;

    @Autowired
    public MedicalCardService(MedicalCardRepo medicalCardRepo) {
        this.medicalCardRepo = medicalCardRepo;
    }

    public MecalCardModel findById(long id) {
        return medicalCardRepo.findById(id).orElse(null);
    }

    public MecalCardModel save(MecalCardModel mecalCardModel) {
        return medicalCardRepo.save(mecalCardModel);
    }
}
