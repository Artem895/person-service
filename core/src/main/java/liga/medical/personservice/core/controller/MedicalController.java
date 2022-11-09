package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.*;
import liga.medical.personservice.core.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/medical")
public class MedicalController {
    private  final PersonDataService personDataService;
    private  final AddressService addressService;
    private  final ContactService contactService;
    private  final IllnessService illnessService;
    private  final MedicalCardService medicalCardService;

    public MedicalController(PersonDataService personDataService, AddressService addressService, ContactService contactService, IllnessService illnessService, MedicalCardService medicalCardService) {
        this.personDataService = personDataService;
        this.addressService = addressService;
        this.contactService = contactService;
        this.illnessService = illnessService;
        this.medicalCardService = medicalCardService;
    }


    @GetMapping(value = "/find/pd/{id}")
    public ResponseEntity <PersonDataModel> findPDbyid(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(personDataService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/find/address/{id}")
    public ResponseEntity <AddressModel> findAdressbyid(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/find/contact/{id}")
    public ResponseEntity <ContactModel> findContactbyid(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(contactService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/find/illness/{id}")
    public ResponseEntity <IllnessModel> findIllnessbyid(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(illnessService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/find/mk/{id}")
    public ResponseEntity <MecalCardModel> findMkbyid(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(medicalCardService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add/pd")
    public ResponseEntity <PersonDataModel> findPDbyid(@RequestBody PersonDataModel personDataModel){
        return new ResponseEntity<>(personDataService.save(personDataModel), HttpStatus.OK);
    }

    @PostMapping(value = "/add/adress")
    public ResponseEntity <AddressModel> findAdressbyid(@RequestBody AddressModel addressModel){
        return new ResponseEntity<>(addressService.save(addressModel), HttpStatus.OK);
    }
    @PostMapping(value = "/add/contact")
    public ResponseEntity <ContactModel> findContactbyid(@RequestBody ContactModel contactModel){
        return new ResponseEntity<>(contactService.save(contactModel), HttpStatus.OK);
    }

    @PostMapping(value = "/add/illness")
    public ResponseEntity <IllnessModel> findIllnessbyid(@RequestBody IllnessModel illnessModel){
        return new ResponseEntity<>(illnessService.save(illnessModel), HttpStatus.OK);
    }
    @PostMapping(value = "/add/mk")
    public ResponseEntity <MecalCardModel> findMkbyid(@RequestBody MecalCardModel mecalCardModel){
        return new ResponseEntity<>(medicalCardService.save(mecalCardModel), HttpStatus.OK);
    }


}
