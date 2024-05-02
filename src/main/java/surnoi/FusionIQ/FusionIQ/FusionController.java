package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Fusion;
import surnoi.FusionIQ.FusionIQ.repo.FusionRepo;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/fusion")
@CrossOrigin(origins = "http://localhost:4200")
public class FusionController {
    @Autowired
    FusionRepo fusionRepo;
    @PostMapping("/api/saveEmployee")
    public ResponseEntity<Fusion> saveRequest(@RequestBody Fusion fusion){
        return new ResponseEntity<>(fusionRepo.save(fusion), HttpStatus.CREATED);
    }
    @GetMapping("/api/getEmployees")
    public ResponseEntity<List<Fusion>> getFusion(){
        return new ResponseEntity<>(fusionRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/getEmployee/{id}")
    public ResponseEntity<Fusion> getEmployee(@PathVariable long id ) {
        Optional<Fusion> employee= fusionRepo.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

