package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.IllnessModel;
import liga.medical.personservice.core.repositories.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IllnessService {
    private final IllnessRepo illnessRepo;

    @Autowired
    public IllnessService(IllnessRepo illnessRepo) {
        this.illnessRepo = illnessRepo;
    }

    public IllnessModel findById(long id) {
        return illnessRepo.findById(id).orElse(null);
    }

    public IllnessModel save(IllnessModel illnessModel) {
        return illnessRepo.save(illnessModel);
    }
}
