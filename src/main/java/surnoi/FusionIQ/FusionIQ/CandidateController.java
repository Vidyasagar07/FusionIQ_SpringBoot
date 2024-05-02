package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Candidates;
import surnoi.FusionIQ.FusionIQ.service.CandidateService;
import surnoi.FusionIQ.FusionIQ.service.EmailSenderService;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class   CandidateController {

    private final CandidateService candidateService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    public CandidateController(CandidateService candidateService)  {
        this.candidateService = candidateService;
    }
    @PostMapping("/add")
    public ResponseEntity<Candidates> addCandidate(@RequestBody Candidates candidates){
        Candidates newcandidates = candidateService.addCandidate(candidates);
//        sendRegistrationSuccessEmail(newcandidates.getEmail(), newcandidates.getFirstName());
        sendRegistrationSuccessEmail(newcandidates.getEmail(), newcandidates.getFirstName(), newcandidates.getUserName(), newcandidates.getPassword());
        return new ResponseEntity<>(candidates, HttpStatus.CREATED);
    }
    private void sendRegistrationSuccessEmail(String to, String firstName, String userName, String password) {
        String subject = "Registration Successful";
        String body = "Dear " + firstName + ",\n\n" +
                "Thank you for registering with our system. Your account has been successfully created.\n" +
                "Here are your login credentials:\n" +
                "Username: " + userName + "\n" +
                "Password: " + password + "\n\n" +
                "SURNOI TECHNOLOGY PRIVATE LIMITED";

        emailSenderService.sendEmail(to, subject, body);
    }
    @PutMapping("/update")
    public ResponseEntity<Candidates> updateCandidate(@RequestBody Candidates candidates){
        Candidates updateCandidate = candidateService.updateCandidate(candidates);
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Candidates> getCandidateById(@PathVariable("id") long id) {
        Candidates candidate = candidateService.findCandidateById(id);
        if (candidate != null) {
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Candidates> getCandidateById(@PathVariable("id") long id){
//        Candidates candidates = candidateService.findCandidateById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @GetMapping("/all")
//    public ResponseEntity<List<Candidates>> getAllCandidates(){
//        List<Candidates> candidates = candidateService.findAllCandidates();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
@GetMapping("/all")
public ResponseEntity<List<Candidates>> getAllCandidates(){
    List<Candidates> candidates = candidateService.findAllCandidates();
    if(!candidates.isEmpty()) {
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
@PutMapping("/updateProgress")
public ResponseEntity<String> updateProgress(@RequestParam long currentStep, @RequestParam long completedSteps) {
    try {
        List<Candidates> candidates = candidateService.findAllCandidates();
        int updatedCount = 0;
        for (Candidates candidate : candidates) {
            candidate.setCurrentStep(currentStep);
            candidate.setCompletedSteps(completedSteps);
            candidateService.updateCandidate(candidate);
            updatedCount++;
        }
        return ResponseEntity.ok("Progress updated for " + updatedCount + " candidates");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Invalid input parameters");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while updating progress for all candidates");
    }
}
    @GetMapping("/progress")
    public ResponseEntity<List<Candidates>> getAllCandidatesProgress() {
        try {
            List<Candidates> candidates = candidateService.findAllCandidates();
            if (!candidates.isEmpty()) {
                  return new ResponseEntity<>(candidates, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Candidates> login(@RequestParam String userName, @RequestParam String password) {
        Candidates authenticatedCandidate = candidateService.authenticateCandidate(userName, password);
        return new ResponseEntity<>(authenticatedCandidate, HttpStatus.OK);
    }


}
