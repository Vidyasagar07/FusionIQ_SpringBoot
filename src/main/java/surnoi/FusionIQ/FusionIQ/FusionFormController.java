package surnoi.FusionIQ.FusionIQ;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.example.springboot.Repo.FusionRepo;
//import com.example.springboot.entity.FusionEntity;
import surnoi.FusionIQ.FusionIQ.data.FusionEntity;
import surnoi.FusionIQ.FusionIQ.repo.FusionRepository;
import surnoi.FusionIQ.FusionIQ.service.EmailSenderService;

@RestController
public class FusionFormController {
    @Autowired
    FusionRepository fusionRepo;
    @Autowired
    public EmailSenderService emailSenderService;
//    @PostMapping("/api/fusion")
//    public ResponseEntity<FusionEntity> saveRequest(@RequestBody FusionEntity fusionEntity){
//        return new ResponseEntity<>(fusionRepo.save(fusionEntity), HttpStatus.CREATED);
//
//    }
//    @PostMapping("/api/fusion")
//    public ResponseEntity<FusionEntity> saveRequest(@RequestBody FusionEntity fusionEntity) {
//        FusionEntity savedEntity = fusionRepo.save(fusionEntity);
//        String to = fusionEntity.getEmail();
//        String subject = "Request Saved Successfully";
//        String body = "Dear " + fusionEntity.getFirst_name() + ",\n\nYour request has been saved successfully.";
//
//        emailSenderService.sendEmail(to, subject, body);
//        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
//    }
    @PostMapping("/api/fusion")
    public ResponseEntity<FusionEntity> saveRequest(@RequestBody FusionEntity fusionEntity) {
        FusionEntity savedEntity = fusionRepo.save(fusionEntity);

        sendRegistrationSuccessEmail(fusionEntity.getEmail(), fusionEntity.getFirst_name());

        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    private void sendRegistrationSuccessEmail(String to, String first_name) {
        String subject = "Request Saved Successfully";
        String body = "Dear " + first_name + ",\n\n" +
                "Thank you for registering with our system.Your request has been saved successfully." + "\n\n" +
                "We appreciate your trust in us and look forward to serving you. If you have any questions or need assistance, please feel free to reach out to us. We will get back to you as soon as possible.\n\n" +
                "Best regards,\n" +
                "SURNOI TECHNOLOGY PRIVATE LIMITED";

        emailSenderService.sendEmail(to, subject, body);
    }

    @GetMapping("/api/fusionall")
    public ResponseEntity<List<FusionEntity>> getEmployeesSortedByIdDescending(){
        Sort sort= Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(fusionRepo.findAll(sort), HttpStatus.OK);

    }
    @GetMapping("/api/fusion/{id}")
    public ResponseEntity<FusionEntity> getEmployee(@PathVariable long id ) {
        Optional<FusionEntity> fusionEntity= fusionRepo.findById(id);
        if (fusionEntity.isPresent()) {
            return new ResponseEntity<>(fusionEntity.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/api/fusion/desc")
    public ResponseEntity<List<FusionEntity>> getEmployeesSortedByIdDescending1(){
        Sort sort= Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(fusionRepo.findAll(sort), HttpStatus.OK);

    }
    @DeleteMapping("/api/delete/fusion/{id}")
    public ResponseEntity<Void> deleteFusionEntity(@PathVariable long id ) {
        Optional<FusionEntity> fusionEntity= fusionRepo.findById(id);
        if (fusionEntity.isPresent()) {
            fusionRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
